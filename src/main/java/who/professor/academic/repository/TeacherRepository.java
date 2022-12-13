package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
