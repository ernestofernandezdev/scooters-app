package org.arquitecturas.grupo17.microservicegateway.controller;

import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicegateway.service.ExampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/scooter-app")
public class MainController {
    private ExampleService exampleService;

    public MainController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScooterDTO>> getScooters() {
        return ResponseEntity.ok(exampleService.getScooters());
    }

}
