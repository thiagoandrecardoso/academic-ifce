package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Student;
import who.professor.academic.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student findById(Long id){
        return studentRepository.findById(id).get();
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentByEmail(String username){
        return studentRepository.findByEmail(username);
    }
}
