package ittec.cisco.apicisco.cis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String showCalendar(Model model) {

        model.addAttribute("title", "Calendario de Apartados");
        return "calendar";
    }
}
