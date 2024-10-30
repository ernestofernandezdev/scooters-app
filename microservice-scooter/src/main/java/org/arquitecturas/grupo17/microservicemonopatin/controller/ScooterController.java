package org.arquitecturas.grupo17.microservicemonopatin.controller;

import org.arquitecturas.grupo17.microservicemonopatin.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicemonopatin.model.Scooter;
import org.arquitecturas.grupo17.microservicemonopatin.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scooter")
public class ScooterController {

    @Autowired
    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping("")
    public List<Scooter> findAllScooters() {
        return this.scooterService.findAll();
    }

    @GetMapping("/{id}")
    public Scooter findById(@PathVariable("id") Long id) {
        return this.scooterService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Scooter> save(@RequestBody ScooterDTO scooterDTO) {
        Scooter userNew = scooterService.create(scooterDTO);
        return ResponseEntity.ok(userNew);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ScooterDTO scooter) {
        scooterService.update(scooter, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable Long id) {
        scooterService.delete(id);
    }
}
