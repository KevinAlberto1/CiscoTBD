package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Profesor;
import ittec.cisco.apicisco.cis.repository.ProfesorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> findAll() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    public Optional<Profesor> findById(String idProfesor) {
        return profesorRepository.findById(idProfesor);
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteById(String idProfesor) {
        profesorRepository.deleteById(idProfesor);
    }
}
