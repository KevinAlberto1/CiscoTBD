package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Solicitante;
import ittec.cisco.apicisco.cis.repository.SolicitanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    public SolicitanteService(SolicitanteRepository solicitanteRepository) {
        this.solicitanteRepository = solicitanteRepository;
    }

    public List<Solicitante> findAll() {
        return (List<Solicitante>) solicitanteRepository.findAll();
    }

    public Optional<Solicitante> findById(Short idSolicitante) {
        return solicitanteRepository.findById(idSolicitante);
    }

    public Solicitante save(Solicitante solicitante) {
        return solicitanteRepository.save(solicitante);
    }

    public void deleteById(Short idSolicitante) {
        solicitanteRepository.deleteById(idSolicitante);
    }
}
