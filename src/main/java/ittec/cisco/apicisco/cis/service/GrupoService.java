package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Grupo;
import ittec.cisco.apicisco.cis.repository.GrupoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<Grupo> findAll() {
        return (List<Grupo>) grupoRepository.findAll();
    }

    public Optional<Grupo> findById(String idGrupo) {
        return grupoRepository.findById(idGrupo);
    }

    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void deleteById(String idGrupo) {
        grupoRepository.deleteById(idGrupo);
    }
}
