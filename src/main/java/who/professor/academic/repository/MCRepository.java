package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.MC;

public interface MCRepository extends JpaRepository<MC, Long> {
}
