package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import who.professor.academic.model.Discipline;
import who.professor.academic.repository.DisciplineRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    @Transactional
    public Discipline findById(Long id) {
        return disciplineRepository.findById(id).get();
    }
}
