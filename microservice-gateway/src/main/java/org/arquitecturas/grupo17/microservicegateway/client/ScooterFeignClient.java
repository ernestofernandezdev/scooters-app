package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="microservice-scooter")
public interface ScooterFeignClient {

    @GetMapping("/api/scooter")
    ResponseEntity<List<ScooterDTO>> getScooter();

}
