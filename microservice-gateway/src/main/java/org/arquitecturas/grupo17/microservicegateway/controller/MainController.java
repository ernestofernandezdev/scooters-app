package org.arquitecturas.grupo17.microservicegateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.*;
import org.arquitecturas.grupo17.microservicegateway.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scooter-app")
@Tag(name = "Scooter App Controller", description = "API for managing scooters, users, accounts, trips, and prices.")
public class MainController {
    private MainService mainService;

    public MainController(MainService exampleService) {
        this.mainService = exampleService;
    }

    @PutMapping("/maintenance/{scooterId}")
    @Operation(summary = "Set maintenance", description = "Marks a scooter as under maintenance.")
    public ResponseEntity<String> setMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.setScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/end-maintenance/{scooterId}")
    @Operation(summary = "End maintenance", description = "Marks a scooter as no longer under maintenance.")
    public ResponseEntity<String> endMaintenance(@PathVariable long scooterId) {
        try {
            this.mainService.endScooterMaintenance(scooterId);
            return ResponseEntity.ok().body("Scooter maintenance ended");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/scooter")
    @Operation(summary = "Add scooter", description = "Adds a new scooter to the database.")
    public ResponseEntity<String> addScooter(@RequestBody ScooterDTO scooterDTO) {
        try {
            this.mainService.addScooter(scooterDTO);
            return ResponseEntity.ok().body("Scooter added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/distance-report")
    @Operation(summary = "Get distance report", description = "Retrieves a report of distances traveled by scooters.")
    public ResponseEntity<List<DistanceReportDTO>> getDistanceReport() {
        try {
            return ResponseEntity.ok(this.mainService.getDistanceReport());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/time-report")
    @Operation(summary = "Get time report", description = "Retrieves a time report, optionally including stops.")
    public ResponseEntity<List<TimeReportDTO>> getTimeReport(@RequestParam boolean stops) {
        try {
            return ResponseEntity.ok(this.mainService.getTimeReport(stops));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/scooter/{scooterId}")
    @Operation(summary = "Delete scooter", description = "Deletes a scooter by its ID.")
    public ResponseEntity<String> deleteScooter(@PathVariable long scooterId) {
        try{
            this.mainService.deleteScooter(scooterId);
            return  ResponseEntity.ok().body("Scooter removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/stop")
    @Operation(summary = "Add stop", description = "Adds a new stop to the system.")
    public ResponseEntity<String> addStop(@RequestBody StopDTO stopDTO) {
        try {
            this.mainService.addStop(stopDTO);
            return ResponseEntity.ok().body("Stop added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/stop/{stopId}")
    @Operation(summary = "Delete stop", description = "Deletes a stop by its ID.")
    public ResponseEntity<String> deleteStop(@PathVariable long stopId) {
        try{
            this.mainService.deleteStop(stopId);
            return  ResponseEntity.ok().body("Stop removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/user")
    @Operation(summary = "Create user", description = "Adds a new user to the system.")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        try {
            this.mainService.createUser(userDTO);
            return ResponseEntity.ok().body("User added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/user/{userId}")
    @Operation(summary = "Delete user", description = "Removes a user by their ID.")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        try{
            this.mainService.deleteUser(userId);
            return  ResponseEntity.ok().body("User removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/user/{userId}")
    @Operation(summary = "Update user", description = "Updates a user's information.")
    public ResponseEntity<String> updateUser(@PathVariable long userId) {
        try {
            this.mainService.updateUser(userId);
            return ResponseEntity.ok().body("User update");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/deactivated-user/{userId}")
    @Operation(summary = "Deactivate user", description = "Deactivates a user.")
    public ResponseEntity<String> deactivateUser(@PathVariable long userId) {
        try {
            this.mainService.deactivateUser(userId);
            return ResponseEntity.ok().body("User deactivated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/account")
    @Operation(summary = "Create account", description = "Adds a new account to the system.")
    public ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO){
        try {
            this.mainService.createAccount(accountDTO);
            return ResponseEntity.ok().body("Account added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/account/{accountId}")
    @Operation(summary = "Delete account", description = "Removes an account by its ID.")
    public ResponseEntity<String> deleteAccount(@PathVariable long accountId) {
        try{
            this.mainService.deleteAccount(accountId);
            return  ResponseEntity.ok().body("Account removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/account/{accountId}")
    @Operation(summary = "Update account", description = "Updates an account's information.")
    public ResponseEntity<String> updateAccount(@PathVariable long accountId) {
        try {
            this.mainService.updateAccount(accountId);
            return ResponseEntity.ok().body("Account update");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/deactivate-account/{accountId}")
    @Operation(summary = "Deactivate account", description = "Deactivates an account.")
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
    @Operation(summary = "Create trip", description = "Adds a new trip to the system.")
    public ResponseEntity<String> createTrip(@RequestBody TripDTO tripDTO){
        try {
            this.mainService.createTrip(tripDTO);
            return ResponseEntity.ok().body("Trip added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/trip/{tripId}")
    @Operation(summary = "Delete trip", description = "Removes a trip by its ID.")
    public ResponseEntity<String> deleteTrip(@PathVariable long tripId) {
        try{
            this.mainService.deleteTrip(tripId);
            return  ResponseEntity.ok().body("Trip removed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/price")
    @Operation(summary = "Create price", description = "Adds a new price entry.")
    public ResponseEntity<String> createPrice(@RequestBody PriceDTO priceDTO){
        try {
            this.mainService.createPrice(priceDTO);
            return ResponseEntity.ok().body("Price added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/price/{id}")
    @Operation(summary = "Update penalty price", description = "Updates a penalty price by ID.")
    public ResponseEntity<String> updatePenaltyPrice(@PathVariable long id, @RequestBody int newPenaltyPrice){
        try {
            this.mainService.updatePenaltyPrice(id, newPenaltyPrice);
            return ResponseEntity.ok().body("Price Updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/trip/scootersWithTrips")
    @Operation(summary = "Get scooters with trips", description = "Retrieves scooters with more than a certain number of trips in a given year.")
    public ResponseEntity<List<ScooterTripsDTO>> getScootersWithMoreThanXTripsInYear(@RequestParam int year, @RequestParam long minTrips) {
        try {
            List<ScooterTripsDTO> scooters = this.mainService.getScootersWithMoreThanXTripsInYear(year, minTrips);

            return ResponseEntity.ok().body(scooters);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/trip/totalBilled")
    @Operation(summary = "Get total billed", description = "Calculates the total billed amount in a specific time range.")
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
    @Operation(summary = "Get scooters by state", description = "Retrieves scooters grouped by their state.")
    public ResponseEntity<List<ScooterStateDTO>> getScootersByState() {
        try {
            return ResponseEntity.ok().body(this.mainService.getScootersByState());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/scooter/close")
    @Operation(summary = "Get close scooters", description = "Finds scooters near a user within a specific distance.")
    public ResponseEntity<List<ScooterDTO>> getCloseScooters(@RequestParam long userId, int distance) {
        try {
            return ResponseEntity.ok().body(this.mainService.getCloseScooters(userId, distance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
