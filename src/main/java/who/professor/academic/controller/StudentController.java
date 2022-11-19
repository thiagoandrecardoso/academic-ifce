package who.professor.academic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "redirect:/student/list";
    }
}
