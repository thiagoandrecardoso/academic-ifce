package who.professor.academic.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Student;
import who.professor.academic.model.Teacher;
import who.professor.academic.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Transactional
    public Teacher findById(Long id){
        return teacherRepository.findById(id).get();
    }

    public void delete(Teacher teacher){
        teacherRepository.delete(teacher);
    }

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> findAllTeacher(){
        return teacherRepository.findAll();
    }

    public void edit(Teacher teacher){
        teacherRepository.save(teacher);
    }
}
