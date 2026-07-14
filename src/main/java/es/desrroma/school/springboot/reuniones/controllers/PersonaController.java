package es.desrroma.school.springboot.reuniones.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.desrroma.school.springboot.reuniones.models.Persona;
import es.desrroma.school.springboot.reuniones.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    private static final List<Persona> personas = new ArrayList<>();

    @GetMapping
    public List<Persona> getAllPersonas(Model model) {
        model.addAttribute("personas", personaService.getAllPersonas());
        return personas;
    }

}
