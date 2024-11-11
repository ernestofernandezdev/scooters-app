package org.arquitecturas.grupo17.microservicescooter.controller;

import org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicescooter.dto.ScooterStateDTO;
import org.arquitecturas.grupo17.microservicescooter.dto.UserDTO;
import org.arquitecturas.grupo17.microservicescooter.service.ScooterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scooter")
public class ScooterController {

    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScooterDTO>> findAll() {
        return ResponseEntity.ok(this.scooterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScooterDTO> findById(@PathVariable("id") long id) {
        ScooterDTO scooterDto = this.scooterService.findById(id);
        return ResponseEntity.ok(scooterDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody ScooterDTO scooterDTO) {
        scooterService.create(scooterDTO);
        return ResponseEntity.ok("Scooter created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody ScooterDTO scooter) {
        scooterService.update(scooter, id);
        return ResponseEntity.ok("Scooter updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        scooterService.delete(id);
        return ResponseEntity.ok("Scooter deleted");
    }

    @PutMapping("/maintenance/{scooterId}")
    public ResponseEntity<Boolean> maintenance(@PathVariable long scooterId) {
        try {
            this.scooterService.setScooterMaintenance(scooterId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PutMapping("/end-maintenance/{scooterId}")
    public ResponseEntity<Boolean> endMaintenance(@PathVariable long scooterId) {
        try {
            this.scooterService.endScooterMaintenance(scooterId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @GetMapping("/states")
    public ResponseEntity<List<ScooterStateDTO>> findAllStates() {
        try {
            return ResponseEntity.ok(this.scooterService.getScootersByState());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/close")
    public ResponseEntity<List<ScooterDTO>> getCloseScooters(@RequestParam int x, @RequestParam int y, @RequestParam int distance) {
        try {
            return ResponseEntity.ok(this.scooterService.getCloseScooters(x, y, distance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
