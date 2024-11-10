package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.StopDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-stop")
public interface StopFeignClient {

    @PostMapping("/api/stop")
    ResponseEntity<String> createStop(@RequestBody StopDTO stopDTO);

    @DeleteMapping("/api/stop/{id}")
    ResponseEntity<String> deleteStop(@PathVariable long id);

    @PutMapping("/api/stop/{id}")
    ResponseEntity<String> updateStop(@PathVariable long id);
}
