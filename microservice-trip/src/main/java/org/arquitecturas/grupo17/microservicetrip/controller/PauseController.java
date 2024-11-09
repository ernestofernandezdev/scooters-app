package org.arquitecturas.grupo17.microservicetrip.controller;

import org.arquitecturas.grupo17.microservicetrip.dto.PauseDTO;
import org.arquitecturas.grupo17.microservicetrip.service.PauseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pause")
public class PauseController {
    private PauseService pauseService;

    public PauseController(PauseService pauseService) {
        this.pauseService = pauseService;
    }

    @GetMapping("")
    public ResponseEntity<List<PauseDTO>> findAll() {
        return ResponseEntity.ok(this.pauseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PauseDTO> findById(@PathVariable("id") long id) {
        PauseDTO pauseDto = this.pauseService.findById(id);
        return ResponseEntity.ok(pauseDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody PauseDTO pauseDto) {
        pauseService.create(pauseDto);
        return ResponseEntity.ok("Pause created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody PauseDTO pauseDto) {
        pauseService.update(pauseDto, id);
        return ResponseEntity.ok("Pause updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        pauseService.delete(id);
        return ResponseEntity.ok("Pause deleted");
    }
}
