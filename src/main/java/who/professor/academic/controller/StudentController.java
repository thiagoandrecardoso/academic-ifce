package who.professor.academic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import who.professor.academic.model.Student;
import who.professor.academic.service.StudentService;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/register")
    public String registerStudent(Student student) {
        return "student/register";
    }

    @PostMapping("/save")
    public String save(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("students", studentService.findAllStudents());
        return "/student/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Student student = studentService.findById(id);
        if (student != null)
            studentService.delete(student);
        return "redirect:/teachers/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) {
        Student student = studentService.findById(id);
        modelMap.addAttribute("student", student);
        return "student/register";
    }

    @PostMapping("/edit")
    public String editStudent(Student student) {
        studentService.edit(student);
        return "redirect:/students/list";
    }
}
