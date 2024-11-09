package org.arquitecturas.grupo17.microservicegateway.controller;

import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicegateway.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scooter-app")
public class MainController {
    private MainService mainService;

    public MainController(MainService exampleService) {
        this.mainService = exampleService;
    }

    @PutMapping("/maintenance/{scooterId}")
    public ResponseEntity<String> setMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.setScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/end-maintenance/{scooterId}")
    public ResponseEntity<String> endMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.endScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance ended");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/scooter")
    public ResponseEntity<String> addScooter(@RequestBody ScooterDTO scooterDTO) {
        try {
            this.mainService.addScooter(scooterDTO);
            return ResponseEntity.ok().body("Scooter added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/distance-report")
    public ResponseEntity<List<DistanceReportDTO>> getDistanceReport() {
        try {
            return ResponseEntity.ok(this.mainService.getDistanceReport());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
