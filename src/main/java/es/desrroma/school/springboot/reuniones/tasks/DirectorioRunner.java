package es.desrroma.school.springboot.reuniones.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.desrroma.school.springboot.reuniones.services.PersonaService;

@Component
@Order(1)
public class DirectorioRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DirectorioRunner.class);
    
    @Autowired
    private PersonaService personaService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Directorio de Personas");
        personaService.getAllPersonas().forEach(persona -> logger.info(persona.toString()));
        logger.info("Fin del Directorio de Personas");
    }

}
