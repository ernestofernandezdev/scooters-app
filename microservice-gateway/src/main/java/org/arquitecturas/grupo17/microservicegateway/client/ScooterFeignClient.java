package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="microservice-scooter")
public interface ScooterFeignClient {

    @PutMapping("/api/scooter/maintenance/{scooterId}")
        ResponseEntity<Boolean> setScooterMaintenance(@PathVariable Long scooterId);

    @PutMapping("/api/scooter/end-maintenance/{scooterId}")
    ResponseEntity<Boolean> endScooterMaintenance(@PathVariable Long scooterId);

    @PostMapping("/api/scooter")
    ResponseEntity<String> createScooter(@RequestBody ScooterDTO scooterDTO);

    @DeleteMapping("/api/scooter/{id}")
    ResponseEntity<String> deleteScooter(@PathVariable long id);


}
