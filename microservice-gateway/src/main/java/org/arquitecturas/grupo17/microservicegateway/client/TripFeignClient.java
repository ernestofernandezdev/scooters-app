package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.PriceDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterTripsDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.TripDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-trip")
public interface TripFeignClient {
    @PostMapping("/api/trip")
    ResponseEntity<String> createTrip(@RequestBody TripDTO tripDTO);

    @DeleteMapping("/api/trip/{id}")
    ResponseEntity<String> deleteTrip(@PathVariable long id);

    @PostMapping("/api/price")
    ResponseEntity<String> createPrice(@RequestBody PriceDTO priceDTO);

    @PutMapping("/api/price/{id}")
    ResponseEntity<String> updatePenaltyPrice(@PathVariable long id, @RequestBody int newPenaltyPrice);

    @GetMapping("/api/trip/scootersWithTrips")
    ResponseEntity<List<ScooterTripsDTO>> getScootersWithMoreThanXTripsInYear(@RequestParam int year, @RequestParam long minTrips);

    @GetMapping("/api/trip/totalBilled")
    ResponseEntity<Integer> getTotalBilled(@RequestBody int year, @RequestBody int startMonth, @RequestBody int endMonth);
}
