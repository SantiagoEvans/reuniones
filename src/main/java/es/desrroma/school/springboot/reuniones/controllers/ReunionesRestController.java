package es.desrroma.school.springboot.reuniones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.desrroma.school.springboot.reuniones.models.Reunion;
import es.desrroma.school.springboot.reuniones.services.ReunionService;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionesRestController {

    @Autowired
    private ReunionService reunionService;

    @GetMapping
    public List<Reunion> getAllReunion() {
        return reunionService.getAllReuniones();
    }
}
