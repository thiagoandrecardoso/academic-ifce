package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Course;
import who.professor.academic.repository.CourseRepository;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public void saveClass(Course c) {
        courseRepository.save(c);
    }

    public void delete(Course c) {
        courseRepository.delete(c);
    }

    public void edit(Course c) {
        courseRepository.save(c);
    }
}
