package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
