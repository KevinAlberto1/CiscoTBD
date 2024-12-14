package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Semestre;
import ittec.cisco.apicisco.cis.repository.SemestreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public List<Semestre> findAll() {
        return (List<Semestre>) semestreRepository.findAll();
    }

    public Optional<Semestre> findById(int idSemestre) {
        return semestreRepository.findById(idSemestre);
    }

    public Semestre save(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    public void deleteById(int idSemestre) {
        semestreRepository.deleteById(idSemestre);
    }
}
