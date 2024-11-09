package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="microservice-trip")
public interface TripFeignClient {

    @GetMapping("/api/trip/distance-report")
    ResponseEntity<List<DistanceReportDTO>> getDistanceReport();
}
