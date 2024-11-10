package org.arquitecturas.grupo17.microservicestop.controller;

import org.arquitecturas.grupo17.microservicestop.dto.StopDTO;
import org.arquitecturas.grupo17.microservicestop.service.StopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stop")
public class StopController {
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("")
    public ResponseEntity<List<StopDTO>> findAll() {
        return ResponseEntity.ok(this.stopService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StopDTO> findById(@PathVariable("id") long id) {
        StopDTO accountDto = this.stopService.findById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody StopDTO stopDTO) {
        stopService.create(stopDTO);
        return ResponseEntity.ok("Stop created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody StopDTO stopDTO) {
        stopService.update(stopDTO, id);
        return ResponseEntity.ok("Stop updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        stopService.delete(id);
        return ResponseEntity.ok("Stop deleted");
    }
}
