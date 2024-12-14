package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Grupo;
import ittec.cisco.apicisco.cis.service.GrupoService;

import java.util.Optional;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public String listGrupos(Model model) {
        model.addAttribute("grupos", grupoService.findAll());
        return "grupos/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createGrupoForm(Model model) {
        model.addAttribute("grupo", new Grupo());
        return "grupos/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveGrupo(@ModelAttribute Grupo grupo) {
        grupoService.save(grupo);
        return "redirect:/grupos"; // Redirige a la lista de grupos
    }

    @GetMapping("/edit/{id}")
    public String editGrupoForm(@PathVariable String id, Model model) {
        Optional<Grupo> grupo = grupoService.findById(id);
        if (grupo.isPresent()) {
            model.addAttribute("grupo", grupo.get());
            return "grupos/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/grupos"; // Si no encuentra el grupo, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateGrupo(@PathVariable String id, @ModelAttribute Grupo grupo) {
        grupo.setIdGrupo(id); // Asegura que mantienes el ID
        grupoService.save(grupo);
        return "redirect:/grupos"; // Redirige a la lista de grupos
    }

    @GetMapping("/delete/{id}")
    public String deleteGrupo(@PathVariable String id) {
        grupoService.deleteById(id);
        return "redirect:/grupos"; // Redirige a la lista de grupos
    }
}
