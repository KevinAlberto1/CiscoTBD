package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Semestre;
import ittec.cisco.apicisco.cis.service.SemestreService;

import java.util.Optional;

@Controller
@RequestMapping("/semestres")
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping
    public String listSemestres(Model model) {
        model.addAttribute("semestres", semestreService.findAll());
        return "semestres/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createSemestreForm(Model model) {
        model.addAttribute("semestre", new Semestre());
        return "semestres/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveSemestre(@ModelAttribute Semestre semestre) {
        semestreService.save(semestre);
        return "redirect:/semestres"; // Redirige a la lista de semestres
    }

    @GetMapping("/edit/{id}")
    public String editSemestreForm(@PathVariable int id, Model model) {
        Optional<Semestre> semestre = semestreService.findById(id);
        if (semestre.isPresent()) {
            model.addAttribute("semestre", semestre.get());
            return "semestres/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/semestres"; // Si no encuentra el semestre, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateSemestre(@PathVariable int id, @ModelAttribute Semestre semestre) {
        semestre.setIdSemestre(id); // Asegura que mantienes el ID
        semestreService.save(semestre);
        return "redirect:/semestres"; // Redirige a la lista de semestres
    }

    @GetMapping("/delete/{id}")
    public String deleteSemestre(@PathVariable int id) {
        semestreService.deleteById(id);
        return "redirect:/semestres"; // Redirige a la lista de semestres
    }
}
