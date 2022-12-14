package who.professor.academic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import who.professor.academic.model.MC;
import who.professor.academic.repository.MCRepository;

@Service
@RequiredArgsConstructor
public class MCService {

    @Autowired
    private final MCRepository mcRepository;

    public void saveClass(MC c) {
        mcRepository.save(c);
    }

    public void delete(MC c) {
        mcRepository.delete(c);
    }

    public void edit(MC c) {
        mcRepository.save(c);
    }
}
