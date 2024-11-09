package org.arquitecturas.grupo17.microservicegateway.service;

import org.arquitecturas.grupo17.microservicegateway.client.ScooterFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private ScooterFeignClient scooterClient;

    public MainService(ScooterFeignClient scooterClient) {
        this.scooterClient = scooterClient;
    }

    public void setScooterMaintenance(long scooterId) throws Exception {
        if (scooterClient.setScooterMaintenance(scooterId).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new Exception("Failed");
        }
    }

    public void endScooterMaintenance(long scooterId) throws Exception {
        if (scooterClient.endScooterMaintenance(scooterId).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new Exception("Failed");
        }
    }

    public void addScooter(ScooterDTO scooterDTO) throws Exception {
        this.scooterClient.createScooter(scooterDTO);
    }

}
