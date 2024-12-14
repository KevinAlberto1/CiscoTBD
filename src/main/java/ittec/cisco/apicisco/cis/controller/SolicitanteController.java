package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Solicitante;
import ittec.cisco.apicisco.cis.service.SolicitanteService;

import java.util.Optional;

@Controller
@RequestMapping("/solicitantes")
public class SolicitanteController {

    private final SolicitanteService solicitanteService;

    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    @GetMapping
    public String listSolicitantes(Model model) {
        model.addAttribute("solicitantes", solicitanteService.findAll());
        return "solicitantes/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createSolicitanteForm(Model model) {
        model.addAttribute("solicitante", new Solicitante());
        return "solicitantes/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveSolicitante(@ModelAttribute Solicitante solicitante) {
        solicitanteService.save(solicitante);
        return "redirect:/solicitantes"; // Redirige a la lista de solicitantes
    }

    @GetMapping("/edit/{id}")
    public String editSolicitanteForm(@PathVariable Short id, Model model) {
        Optional<Solicitante> solicitante = solicitanteService.findById(id);
        if (solicitante.isPresent()) {
            model.addAttribute("solicitante", solicitante.get());
            return "solicitantes/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/solicitantes"; // Si no encuentra el solicitante, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateSolicitante(@PathVariable Short id, @ModelAttribute Solicitante solicitante) {
        solicitante.setIdSolicitante(id); // Asegura que mantienes el ID
        solicitanteService.save(solicitante);
        return "redirect:/solicitantes"; // Redirige a la lista de solicitantes
    }

    @GetMapping("/delete/{id}")
    public String deleteSolicitante(@PathVariable Short id) {
        solicitanteService.deleteById(id);
        return "redirect:/solicitantes"; // Redirige a la lista de solicitantes
    }
}
