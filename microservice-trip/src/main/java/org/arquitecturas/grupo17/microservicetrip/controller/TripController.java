package org.arquitecturas.grupo17.microservicetrip.controller;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trip")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("")
    public ResponseEntity<List<TripDTO>> findAll() {
        return ResponseEntity.ok(this.tripService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> findById(@PathVariable("id") Long id) {
        TripDTO tripDto = this.tripService.findById(id);
        return ResponseEntity.ok(tripDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody TripDTO tripDto) {
        tripService.create(tripDto);
        return ResponseEntity.ok("Trip created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody TripDTO tripDto) {
        tripService.update(tripDto, id);
        return ResponseEntity.ok("Trip updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tripService.delete(id);
        return ResponseEntity.ok("Trip deleted");
    }

    @GetMapping("/distance-report")
    public ResponseEntity<List<DistanceReportDTO>> getDistanceReport() {
        try {
            return ResponseEntity.ok(this.tripService.getDistanceReport());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
