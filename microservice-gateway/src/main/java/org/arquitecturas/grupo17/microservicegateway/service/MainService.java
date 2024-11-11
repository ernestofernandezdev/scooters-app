package org.arquitecturas.grupo17.microservicegateway.service;

import org.arquitecturas.grupo17.microservicegateway.client.AccountUserFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.ScooterFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.TripFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicegateway.client.StopFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class MainService {
    private final ScooterFeignClient scooterClient;
    private final StopFeignClient stopClient;
    private final AccountUserFeignClient accountUserClient;
    private final TripFeignClient tripClient;

    public MainService(ScooterFeignClient scooterClient, StopFeignClient stopClient,AccountUserFeignClient accountUserClient, TripFeignClient tripClient) {
        this.scooterClient = scooterClient;
        this.stopClient = stopClient;
        this.accountUserClient = accountUserClient;
        this.tripClient = tripClient;
    }

    //Scooter

    public void setScooterMaintenance(long scooterId) throws Exception {
        if (scooterClient.setScooterMaintenance(scooterId).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new Exception("Failed");
        }
    }

    public void endScooterMaintenance(long scooterId) throws Exception {
        if (scooterClient.endScooterMaintenance(scooterId).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new Exception("Failed");
        }
    }

    public void addScooter(ScooterDTO scooterDTO) throws Exception {
        this.scooterClient.createScooter(scooterDTO);
    }

    public List<DistanceReportDTO> getDistanceReport() throws Exception {
        return this.tripClient.getDistanceReport().getBody();
    }

    public List<TimeReportDTO> getTimeReport(boolean stops) throws Exception {
        ResponseEntity<List<TimeReportDTO>> response = this.tripClient.getTimeReport(stops);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        } else {
            throw new Exception("BadRequest");
        }
    }

    public void deleteScooter(long scooterId) {
        try {
            this.scooterClient.deleteScooter(scooterId);
        } catch (Exception e) {
            System.out.println("Error deleting scooter: " + e.getMessage());
        }
    }

// Stop

    public void addStop(StopDTO stopDTO) {
        try {
            this.stopClient.createStop(stopDTO);
        } catch (Exception e) {
            System.out.println("Error adding stop: " + e.getMessage());

        }
    }

    public void deleteStop(long scooterId) {
        try {
            this.scooterClient.deleteScooter(scooterId);
        } catch (Exception e) {
            System.out.println("Error deleting stop: " + e.getMessage());

        }
    }

// AccountUser

    public void createUser(UserDTO userDTO) {
        try {
            this.accountUserClient.createUser(userDTO);
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());

        }
    }

    public void deleteUser(long userId) {
        try {
            this.accountUserClient.deleteUser(userId);
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());

        }
    }

    public void updateUser(long userId) {
        try {
            this.accountUserClient.updateUser(userId);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());

        }
    }

    public void deactivateUser(long userId) {
        try {
            this.accountUserClient.deactivateUser(userId);
        } catch (Exception e) {
            System.out.println("Error deactivating user: " + e.getMessage());

        }
    }

    public void createAccount(@RequestBody AccountDTO accountDTO) {
        try {
            this.accountUserClient.createAccount(accountDTO);
        } catch (Exception e) {
            System.out.println("Error creating account: " + e.getMessage());

        }
    }

    public void deleteAccount(@PathVariable long accountId) {
        try {
            this.accountUserClient.deleteAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());

        }
    }

    public void updateAccount(@PathVariable long accountId) {
        try {
            this.accountUserClient.updateAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error updating account: " + e.getMessage());

        }
    }

    public void deactivateAccount(@PathVariable long accountId) {
        try {
            this.accountUserClient.deactivateAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error deactivating account: " + e.getMessage());

        }
    }

    //Trip

    public void createTrip(TripDTO tripDTO) {
        try {
            this.tripClient.createTrip(tripDTO);
        } catch (Exception e) {
            System.out.println("Error creating trip: " + e.getMessage());

        }
    }

    public void deleteTrip(long tripId) {
        try {
            this.tripClient.deleteTrip(tripId);
        } catch (Exception e) {
            System.out.println("Error deleting trip with ID: " + tripId);

        }
    }

    public void createPrice(PriceDTO priceDTO) {
        try {
            this.tripClient.createPrice(priceDTO);
        } catch (Exception e) {
            System.out.println("Error creating price: " + e.getMessage());

        }
    }

    public void updatePenaltyPrice(long priceId, int newPenaltyPrice){
        try {
            this.tripClient.updatePenaltyPrice(priceId, newPenaltyPrice);
        } catch (Exception e) {
            System.out.println("Error updating price: " + e.getMessage());

        }
    }

    public List<ScooterTripsDTO> getScootersWithMoreThanXTripsInYear(int year, long minTrips) {
        try {
            ResponseEntity<List<ScooterTripsDTO>> response = this.tripClient.getScootersWithMoreThanXTripsInYear(year, minTrips);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new RuntimeException("Error getting scooters: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting scooters: " + e.getMessage());
        }
    }

    public int getTotalBilled(int year, int startMonth, int endMonth) {
        try {
            ResponseEntity<Integer> response = this.tripClient.getTotalBilled(year, startMonth, endMonth);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new RuntimeException("Error getting total billed: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting total billed: " + e.getMessage());
        }
    }

    public List<ScooterStateDTO> getScootersByState() {
        return this.scooterClient.getScooterStates().getBody();
    }

    public List<ScooterDTO> getCloseScooters(long userId, int distance) throws Exception {
        UserDTO userDTO;
        ResponseEntity<UserDTO> userResponse = this.accountUserClient.getUser(userId);
        if (userResponse.getStatusCode().is2xxSuccessful()) {
            userDTO = userResponse.getBody();
        } else {
            throw new Exception("error");
        }

        ResponseEntity<List<ScooterDTO>> scootersResponse = this.scooterClient.getCloseScooters(userDTO.getX(), userDTO.getY(), distance);
        if (scootersResponse.getStatusCode().is2xxSuccessful()) {
            return scootersResponse.getBody();
        } else {
            throw new Exception("error");
        }
    }

}
