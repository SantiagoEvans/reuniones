package es.desrroma.school.springboot.reuniones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.desrroma.school.springboot.reuniones.data.ReunionRepository;
import es.desrroma.school.springboot.reuniones.models.Reunion;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }

    public Reunion getById(long idReunion) {
        return reunionRepository.findById(idReunion)
                .orElseThrow(() -> new RuntimeException("Reunion not found with id: " + idReunion));        
    }

}
