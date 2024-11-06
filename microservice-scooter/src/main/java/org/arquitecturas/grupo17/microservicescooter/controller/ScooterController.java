package org.arquitecturas.grupo17.microservicescooter.controller;

import org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO;
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
    public ResponseEntity<List<ScooterDTO>> findAllScooters() {
        return ResponseEntity.ok(this.scooterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScooterDTO> findById(@PathVariable("id") Long id) {
        ScooterDTO scooterDto = this.scooterService.findById(id);
        return ResponseEntity.ok(scooterDto);
    }

    @PostMapping("")
    public ResponseEntity<ScooterDTO> save(@RequestBody ScooterDTO scooterDTO) {
        ScooterDTO scooterDto = scooterService.create(scooterDTO);
        return ResponseEntity.ok(scooterDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ScooterDTO scooter) {
        scooterService.update(scooter, id);
        return ResponseEntity.ok("Scooter updated");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scooterService.delete(id);
    }
}
