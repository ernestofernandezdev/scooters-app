package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.PriceDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.TripDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-trip")
public interface TripFeignClient {
    @PostMapping("/api/trip")
    ResponseEntity<String> createTrip(@RequestBody TripDTO tripDTO);

    @DeleteMapping("/api/trip/{id}")
    ResponseEntity<String> deleteTrip(@PathVariable long id);

    @PostMapping("/api/price")
    ResponseEntity<String> createPrice(@RequestBody PriceDTO priceDTO);

/*
    @PutMapping("/api/trip/price/{priceId}")
    ResponseEntity<String> setExtraFee(@PathVariable long priceId);
*/
}
