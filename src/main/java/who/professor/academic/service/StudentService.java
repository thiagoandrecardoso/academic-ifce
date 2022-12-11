package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Student;
import who.professor.academic.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void saveStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
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

    public void delete(Student student){
        studentRepository.delete(student);
    }

    public void edit(Student student){
        studentRepository.save(student);
    }
}
