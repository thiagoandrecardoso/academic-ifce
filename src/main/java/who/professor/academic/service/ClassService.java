package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Class;
import who.professor.academic.repository.ClassRepository;

@Service
@RequiredArgsConstructor
public class ClassService {

    @Autowired
    private final ClassRepository classRepository;

    public void saveClass(Class c) {
        classRepository.save(c);
    }

    public void delete(Class c) {
        classRepository.delete(c);
    }

    public void edit(Class c) {
        classRepository.save(c);
    }
}
