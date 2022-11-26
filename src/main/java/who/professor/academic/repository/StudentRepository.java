package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String username);
}
