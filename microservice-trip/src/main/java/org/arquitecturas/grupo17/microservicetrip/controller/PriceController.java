package org.arquitecturas.grupo17.microservicetrip.controller;

import org.arquitecturas.grupo17.microservicetrip.dto.PriceDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Price;
import org.arquitecturas.grupo17.microservicetrip.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/price")
public class PriceController {
    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{scooterId}")
    public ResponseEntity<Integer> getPrice(@PathVariable int scooterId) {
        return ResponseEntity.ok(this.priceService.find(scooterId));
    }

    @PostMapping("")
    public ResponseEntity<String> savePrice(@RequestBody PriceDTO priceDto) {
        this.priceService.save(priceDto);
        return ResponseEntity.ok("Price saved successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePenaltyPrice(@PathVariable long id, @RequestBody int newPenaltyPrice) {
        this.priceService.updatePenaltyPrice(id, newPenaltyPrice);
        return ResponseEntity.ok("Price updated successfully");
    }
}
