package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Materia;
import ittec.cisco.apicisco.cis.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public List<Materia> findAll() {
        return (List<Materia>) materiaRepository.findAll();
    }

    public Optional<Materia> findById(String idMateria) {
        return materiaRepository.findById(idMateria);
    }

    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void deleteById(String idMateria) {
        materiaRepository.deleteById(idMateria);
    }
}
