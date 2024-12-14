package ittec.cisco.apicisco.cis.controller;

import ittec.cisco.apicisco.cis.model.Solicitud; // Cambiado a model
import ittec.cisco.apicisco.cis.service.SolicitudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public String getSolicitudesByGrupo(@RequestParam("idGrupo") String idGrupo, Model model) {
        List<Solicitud> solicitudes = solicitudService.findByGrupo(idGrupo);
        model.addAttribute("solicitudes", solicitudes);
        return "solicitudes/list";
    }
}
