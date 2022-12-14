package who.professor.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import who.professor.academic.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
