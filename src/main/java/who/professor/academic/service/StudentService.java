package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Student;
import who.professor.academic.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
