package es.desrroma.school.springboot.reuniones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.desrroma.school.springboot.reuniones.models.Persona;
import es.desrroma.school.springboot.reuniones.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;

    @RequestMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}
