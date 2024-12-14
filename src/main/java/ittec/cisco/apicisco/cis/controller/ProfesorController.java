package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Profesor;
import ittec.cisco.apicisco.cis.service.ProfesorService;

import java.util.Optional;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public String listProfesores(Model model) {
        model.addAttribute("profesores", profesorService.findAll());
        return "profesores/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createProfesorForm(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "profesores/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveProfesor(@ModelAttribute Profesor profesor) {
        profesorService.save(profesor);
        return "redirect:/profesores"; // Redirige a la lista de profesores
    }

    @GetMapping("/edit/{id}")
    public String editProfesorForm(@PathVariable String id, Model model) {
        Optional<Profesor> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            return "profesores/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/profesores"; // Si no encuentra el profesor, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateProfesor(@PathVariable String id, @ModelAttribute Profesor profesor) {
        profesor.setIdProfesor(id); // Asegura que mantienes el ID
        profesorService.save(profesor);
        return "redirect:/profesores"; // Redirige a la lista de profesores
    }

    @GetMapping("/delete/{id}")
    public String deleteProfesor(@PathVariable String id) {
        profesorService.deleteById(id);
        return "redirect:/profesores"; // Redirige a la lista de profesores
    }
}
