package org.arquitecturas.grupo17.microservicegateway.controller;

import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.*;
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

    // Registrar monopatín en mantenimiento (debe marcarse como no disponible para su uso)
    @PutMapping("/maintenance/{scooterId}")
    public ResponseEntity<String> setMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.setScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Registrar fin de mantenimiento de monopatín
    @PutMapping("/end-maintenance/{scooterId}")
    public ResponseEntity<String> endMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.endScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance ended");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Agregar monopatín
    @PostMapping("/scooter")
    public ResponseEntity<String> addScooter(@RequestBody ScooterDTO scooterDTO) {
        try {
            this.mainService.addScooter(scooterDTO);
            return ResponseEntity.ok().body("Scooter added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Quitar monopatín
    @DeleteMapping("/scooter/{scooterId}")
    public ResponseEntity<String> deleteScooter(@PathVariable long scooterId) {
        try{
            this.mainService.deleteScooter(scooterId);
            return  ResponseEntity.ok().body("Scooter removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Registrar parada
    @PostMapping("/stop")
    public ResponseEntity<String> addStop(@RequestBody StopDTO stopDTO) {
        try {
            this.mainService.addStop(stopDTO);
            return ResponseEntity.ok().body("Stop added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Quitar parada
    @DeleteMapping("/stop/{stopId}")
    public ResponseEntity<String> deleteStop(@PathVariable long stopId) {
        try{
            this.mainService.deleteStop(stopId);
            return  ResponseEntity.ok().body("Stop removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Definir precio
    @PostMapping("/price")
    public ResponseEntity<String> createPrice(@RequestBody PriceDTO priceDTO){
        try {
            this.mainService.createPrice(priceDTO);
            return ResponseEntity.ok().body("Price added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Definir tarifa extra para reinicio por pausa extensa
    @PutMapping("/price/{id}")
    public ResponseEntity<String> updatePenaltyPrice(@PathVariable long id, @RequestBody int newPenaltyPrice){
        try {
            this.mainService.updatePenaltyPrice(id, newPenaltyPrice);
            return ResponseEntity.ok().body("Price Updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Anular cuenta
    @PutMapping("/deactivate-account/{accountId}")
    public ResponseEntity<String> deactivateAccount(@PathVariable long accountId) {
        try {
            this.mainService.deactivateAccount(accountId);
            return ResponseEntity.ok().body("Account deactivated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Generar reporte de uso de monopatines por kilómetros
    @GetMapping("/distance-report")
    public ResponseEntity<List<DistanceReportDTO>> getDistanceReport() {
        try {
            return ResponseEntity.ok(this.mainService.getDistanceReport());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Generar reporte de uso de monopatines por tiempo con pausas (stops=true)
    // Generar reporte de uso de monopatines por tiempo sin pausas (stops=false)
    @GetMapping("/time-report")
    public ResponseEntity<List<TimeReportDTO>> getTimeReport(@RequestParam boolean stops) {
        try {
            return ResponseEntity.ok(this.mainService.getTimeReport(stops));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    // 3)a) Ya está implementado más arriba

    // 3)b) Ya está implementado más arriba

    // 3)c) Como administrador quiero consultar los monopatines con más de X viajes en un cierto año
    @GetMapping("/trip/scootersWithTrips")
    public ResponseEntity<List<ScooterTripsDTO>> getScootersWithMoreThanXTripsInYear(@RequestParam int year, @RequestParam long minTrips) {
        try {
            List<ScooterTripsDTO> scooters = this.mainService.getScootersWithMoreThanXTripsInYear(year, minTrips);

            return ResponseEntity.ok().body(scooters);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 3)d) Como administrador quiero consultar el total facturado en un rango de meses de cierto año
    @GetMapping("/trip/totalBilled")
    public ResponseEntity<Integer> getTotalBilled(@RequestParam int year,
                                                  @RequestParam int startMonth,
                                                  @RequestParam int endMonth) {
        try {
            int total = this.mainService.getTotalBilled(year, startMonth, endMonth);
            return ResponseEntity.ok().body(total);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 3)e) Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
    //      versus la cantidad de monopatines actualmente en mantenimiento
    @GetMapping("/scooter/states")
    public ResponseEntity<List<ScooterStateDTO>> getScootersByState() {
        try {
            return ResponseEntity.ok().body(this.mainService.getScootersByState());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 3)f) Ya está implementado más arriba

    // 3)g) Como usuario quiero lun listado de los monopatines cercanos a mi zona, para poder encontrar
    //      un monopatín cerca de mi ubicación
    @GetMapping("/scooter/close")
    public ResponseEntity<List<ScooterDTO>> getCloseScooters(@RequestParam long userId, int distance) {
        try {
            return ResponseEntity.ok().body(this.mainService.getCloseScooters(userId, distance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
