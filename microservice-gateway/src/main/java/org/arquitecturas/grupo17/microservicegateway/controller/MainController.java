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

    @GetMapping("/time-report")
    public ResponseEntity<List<TimeReportDTO>> getTimeReport(@RequestParam boolean stops) {
        try {
            return ResponseEntity.ok(this.mainService.getTimeReport(stops));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/scooter/{scooterId}")
    public ResponseEntity<String> deleteScooter(@PathVariable long scooterId) {
        try{
            this.mainService.deleteScooter(scooterId);
            return  ResponseEntity.ok().body("Scooter removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<String> addStop(@RequestBody StopDTO stopDTO) {
        try {
            this.mainService.addStop(stopDTO);
            return ResponseEntity.ok().body("Stop added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/stop/{stopId}")
    public ResponseEntity<String> deleteStop(@PathVariable long stopId) {
        try{
            this.mainService.deleteStop(stopId);
            return  ResponseEntity.ok().body("Stop removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        try {
            this.mainService.createUser(userDTO);
            return ResponseEntity.ok().body("User added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        try{
            this.mainService.deleteUser(userId);
            return  ResponseEntity.ok().body("User removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable long userId) {
        try {
            this.mainService.updateUser(userId);
            return ResponseEntity.ok().body("User update");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/deactivated-user/{userId}")
    public ResponseEntity<String> deactivateUser(@PathVariable long userId) {
        try {
            this.mainService.deactivateUser(userId);
            return ResponseEntity.ok().body("User deactivated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO){
        try {
            this.mainService.createAccount(accountDTO);
            return ResponseEntity.ok().body("Account added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable long accountId) {
        try{
            this.mainService.deleteAccount(accountId);
            return  ResponseEntity.ok().body("Account removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/account/{accountId}")
    public ResponseEntity<String> updateAccount(@PathVariable long accountId) {
        try {
            this.mainService.updateAccount(accountId);
            return ResponseEntity.ok().body("Account update");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/deactivate-account/{accountId}")
    public ResponseEntity<String> deactivateAccount(@PathVariable long accountId) {
        try {
            this.mainService.deactivateAccount(accountId);
            return ResponseEntity.ok().body("Account deactivated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Trip

    @PostMapping("/trip")
    public ResponseEntity<String> createTrip(@RequestBody TripDTO tripDTO){
        try {
            this.mainService.createTrip(tripDTO);
            return ResponseEntity.ok().body("Trip added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/trip/{tripId}")
    public ResponseEntity<String> deleteTrip(@PathVariable long tripId) {
        try{
            this.mainService.deleteTrip(tripId);
            return  ResponseEntity.ok().body("Trip removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/price")
    public ResponseEntity<String> createPrice(@RequestBody PriceDTO priceDTO){
        try {
            this.mainService.createPrice(priceDTO);
            return ResponseEntity.ok().body("Price added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<String> updatePenaltyPrice(@PathVariable long id, @RequestBody int newPenaltyPrice){
        try {
            this.mainService.updatePenaltyPrice(id, newPenaltyPrice);
            return ResponseEntity.ok().body("Price Updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/trip/scootersWithTrips")
    public ResponseEntity<List<ScooterTripsDTO>> getScootersWithMoreThanXTripsInYear(@RequestParam int year, @RequestParam long minTrips) {
        try {
            List<ScooterTripsDTO> scooters = this.mainService.getScootersWithMoreThanXTripsInYear(year, minTrips);

            return ResponseEntity.ok().body(scooters);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }


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

    @GetMapping("/scooter/states")
    public ResponseEntity<List<ScooterStateDTO>> getScootersByState() {
        try {
            return ResponseEntity.ok().body(this.mainService.getScootersByState());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/scooter/close")
    public ResponseEntity<List<ScooterDTO>> getCloseScooters(@RequestParam long userId, int distance) {
        try {
            return ResponseEntity.ok().body(this.mainService.getCloseScooters(userId, distance));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

}
