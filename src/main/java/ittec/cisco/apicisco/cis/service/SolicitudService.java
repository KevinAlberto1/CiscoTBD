package ittec.cisco.apicisco.cis.service;

import ittec.cisco.apicisco.cis.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<ittec.cisco.apicisco.cis.model.Solicitud> findByGrupo(String idGrupo) {
        return solicitudRepository.findByGrupo(idGrupo);
    }
}
