package cl.praxis.gestorbiblioteca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/logMessage")
    public String logMessage(@RequestParam String message) {
        LOGGER.info("Mensaje del usuario: {}", message);
        return "Mensaje enviado: " + message;
    }
}

