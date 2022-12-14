package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
