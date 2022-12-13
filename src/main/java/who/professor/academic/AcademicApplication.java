package who.professor.academic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import who.professor.academic.model.Student;
import who.professor.academic.repository.StudentRepository;

@SpringBootApplication
public class AcademicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AcademicApplication.class, args);
    }

    @Autowired
    StudentRepository studentRepository;

    Student student;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        student = new Student();
//        student.setName("Thi");
//        student.setPassword(passwordEncoder.encode("123456"));
//        student.setEmail("thi@mail.com");
//        student.setStatus(true);
//        student.setRating(3L);
//        studentRepository.save(student);
    }
}
