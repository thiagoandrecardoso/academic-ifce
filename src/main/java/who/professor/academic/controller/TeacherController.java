package who.professor.academic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import who.professor.academic.model.Teacher;
import who.professor.academic.service.TeacherService;


@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/register")
    public String registerStudent(Teacher teacher) {
        return "teacher/register";
    }

    @PostMapping("/save")
    public String save(Teacher teacher) {
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
}
