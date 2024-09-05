package cl.praxis.restaurante.controllers;

import cl.praxis.restaurante.services.impl.CamareroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CamareroController {
    @Autowired
    private CamareroService camareroService;

    @GetMapping
    public String mostrarCamareros(Model model) {
        model.addAttribute("camareros", camareroService.getAll());
        return "index";
    }
}
