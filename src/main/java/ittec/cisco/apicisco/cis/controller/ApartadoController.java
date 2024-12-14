package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ittec.cisco.apicisco.cis.model.Apartado;
import ittec.cisco.apicisco.cis.service.ApartadoService;

import java.util.Optional;

@Controller
@RequestMapping("/apartados")
public class ApartadoController {

    private final ApartadoService apartadoService;

    public ApartadoController(ApartadoService apartadoService) {
        this.apartadoService = apartadoService;
    }

    @GetMapping
    public String listApartados(Model model) {
        model.addAttribute("apartados", apartadoService.findAll());
        return "apartados/list"; // Muestra la vista list.html
    }

    @GetMapping("/create")
    public String createApartadoForm(Model model) {
        model.addAttribute("apartado", new Apartado());
        return "apartados/create"; // Muestra el formulario create.html
    }

    @PostMapping
    public String saveApartado(@ModelAttribute Apartado apartado) {
        apartadoService.save(apartado);
        return "redirect:/apartados"; // Redirige a la lista de apartados
    }

    @GetMapping("/edit/{id}")
    public String editApartadoForm(@PathVariable Integer id, Model model) {
        Optional<Apartado> apartado = apartadoService.findById(id);
        if (apartado.isPresent()) {
            model.addAttribute("apartado", apartado.get());
            return "apartados/edit"; // Muestra el formulario edit.html
        } else {
            return "redirect:/apartados"; // Si no encuentra el apartado, redirige
        }
    }

    @PostMapping("/edit/{id}")
    public String updateApartado(@PathVariable Integer id, @ModelAttribute Apartado apartado) {
        apartado.setId(id); // Asegura que mantienes el ID
        apartadoService.save(apartado);
        return "redirect:/apartados"; // Redirige a la lista de apartados
    }

    @GetMapping("/delete/{id}")
    public String deleteApartado(@PathVariable Integer id) {
        apartadoService.deleteById(id);
        return "redirect:/apartados"; // Redirige a la lista de apartados
    }
}
