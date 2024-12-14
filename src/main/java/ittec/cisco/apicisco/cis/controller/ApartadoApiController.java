package ittec.cisco.apicisco.cis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ittec.cisco.apicisco.cis.model.Apartado;
import ittec.cisco.apicisco.cis.service.ApartadoService;

import java.util.List;

@RestController
public class ApartadoApiController {

    private final ApartadoService apartadoService;

    public ApartadoApiController(ApartadoService apartadoService) {
        this.apartadoService = apartadoService;
    }

    @GetMapping("/api/apartados")
    public List<Apartado> getAllApartados() {
        return apartadoService.findAll();
    }
}
