package org.arquitecturas.grupo17.microservicegateway.service;

import org.arquitecturas.grupo17.microservicegateway.client.ScooterFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {
    private ScooterFeignClient scooterClient;

    public ExampleService(ScooterFeignClient scooterClient) {
        this.scooterClient = scooterClient;
    }

    public List<ScooterDTO> getScooters() {
        return this.scooterClient.getScooter().getBody();
    }
}
