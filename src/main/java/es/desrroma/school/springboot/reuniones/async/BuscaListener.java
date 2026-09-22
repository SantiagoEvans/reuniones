package es.desrroma.school.springboot.reuniones.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.desrroma.school.springboot.reuniones.models.Persona;
import es.desrroma.school.springboot.reuniones.models.Reunion;
import es.desrroma.school.springboot.reuniones.services.PersonaService;
import es.desrroma.school.springboot.reuniones.services.ReunionService;
import es.desrroma.school.springboot.reuniones.async.InfoBusca;
import tools.jackson.databind.ObjectMapper;

@Component
public class BuscaListener {

    private static final Logger logger = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper objectMapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;
    
    public BuscaListener(ObjectMapper objectMapper, PersonaService personaService, ReunionService reunionService) {
        this.objectMapper = objectMapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String message) {
        try {
            InfoBusca infoBusca = objectMapper.readValue(message, InfoBusca.class);
            logger.info("Received message: {}", infoBusca);
            Persona persona = personaService.getById(infoBusca.getIdAsistente());
            Reunion reunion = reunionService.getById(infoBusca.getIdReunion());
            logger.info("{} {} Tiene una reunion a las: {}", persona.getNombre(), persona.getApellidos(), reunion.getFecha());

        } catch (Exception e) {
            logger.error("Error processing message: {}", message, e);
        }
    }

}
