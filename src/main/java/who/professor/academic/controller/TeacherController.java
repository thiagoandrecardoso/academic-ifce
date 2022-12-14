package who.professor.academic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import who.professor.academic.model.Discipline;
import who.professor.academic.model.Teacher;
import who.professor.academic.service.DisciplineService;
import who.professor.academic.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final DisciplineService disciplineService;


    @GetMapping("/register")
    public String registerStudent(Teacher teacher) {
        return "teacher/register";
    }

    @PostMapping("/save")
    public String save(Teacher teacher) {
        List<Long> cods = getCodByString(teacher.getCodDisciplines());
        if (cods != null) {
            List<Discipline> disciplines = new ArrayList<>();
            for (Long id : cods) {
                Discipline d = disciplineService.findById(id);
                disciplines.add(d);
            }
            teacher.setDisciplines(disciplines);
        }
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers/list";
    }

    @GetMapping("list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("teachers", teacherService.findAllTeacher());
        return "/teacher/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Teacher teacher = teacherService.findById(id);
        if(teacher != null)
            teacherService.delete(teacher);
        return "redirect:/teachers/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap){
        Teacher teacher = teacherService.findById(id);
        modelMap.addAttribute("teacher", teacher);
        return "teacher/register";
    }

    @PostMapping("/edit")
    public String editTeacher(Teacher teacher){
        teacherService.edit(teacher);
        return "redirect:/teachers/list";
    }

    public List<Long> getCodByString(String codDisciplines){
        if(codDisciplines == null || codDisciplines.isEmpty())
            return null;

        List<Long> cods = new ArrayList<Long>();
        for (String s : codDisciplines.split(","))
            cods.add(Long.valueOf(s.trim()));

        return cods;

//        return Stream.of(codDisciplines.trim().split("\\\\s*,\\\\s*"))
//                .map(Long::parseLong)
//                .collect(Collectors.toList());
    }
}
