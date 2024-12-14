package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Materia;
import ittec.cisco.apicisco.cis.service.MateriaService;

import java.util.Optional;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public String listMaterias(Model model) {
        model.addAttribute("materias", materiaService.findAll());
        return "materias/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createMateriaForm(Model model) {
        model.addAttribute("materia", new Materia());
        return "materias/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveMateria(@ModelAttribute Materia materia) {
        materiaService.save(materia);
        return "redirect:/materias"; // Redirige a la lista de materias
    }

    @GetMapping("/edit/{id}")
    public String editMateriaForm(@PathVariable String id, Model model) {
        Optional<Materia> materia = materiaService.findById(id);
        if (materia.isPresent()) {
            model.addAttribute("materia", materia.get());
            return "materias/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/materias"; // Si no encuentra la materia, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateMateria(@PathVariable String id, @ModelAttribute Materia materia) {
        materia.setId_Materia(id); // Asegura que mantienes el ID
        materiaService.save(materia);
        return "redirect:/materias"; // Redirige a la lista de materias
    }

    @GetMapping("/delete/{id}")
    public String deleteMateria(@PathVariable String id) {
        materiaService.deleteById(id);
        return "redirect:/materias"; // Redirige a la lista de materias
    }
}
