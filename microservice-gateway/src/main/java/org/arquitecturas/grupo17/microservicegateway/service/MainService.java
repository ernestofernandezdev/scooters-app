package org.arquitecturas.grupo17.microservicegateway.service;

import org.arquitecturas.grupo17.microservicegateway.client.AccountUserFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.ScooterFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.StopFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.TripFeignClient;
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
    private final AccountUserFeignClient accountUserFeignClient;
    private final TripFeignClient tripFeignClient;

    public MainService(ScooterFeignClient scooterClient, StopFeignClient stopClient,AccountUserFeignClient accountUserFeignClient, TripFeignClient tripFeignClient) {
        this.scooterClient = scooterClient;
        this.stopClient = stopClient;
        this.accountUserFeignClient = accountUserFeignClient;
        this.tripFeignClient = tripFeignClient;
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

    public void deleteScooter(Long scooterId) {
        try {
            this.scooterClient.deleteScooter(scooterId);
        } catch (Exception e) {
            System.out.println("Error deleting scooter: " + e.getMessage());
            e.printStackTrace();
        }
    }

// Stop

    public void addStop(StopDTO stopDTO) {
        try {
            this.stopClient.createStop(stopDTO);
        } catch (Exception e) {
            System.out.println("Error adding stop: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStop(Long scooterId) {
        try {
            this.scooterClient.deleteScooter(scooterId);
        } catch (Exception e) {
            System.out.println("Error deleting stop: " + e.getMessage());
            e.printStackTrace();
        }
    }

// AccountUser

    public void createUser(UserDTO userDTO) {
        try {
            this.accountUserFeignClient.createUser(userDTO);
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUser(Long userId) {
        try {
            this.accountUserFeignClient.deleteUser(userId);
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateUser(Long userId) {
        try {
            this.accountUserFeignClient.updateUser(userId);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deactivateUser(Long userId) {
        try {
            this.accountUserFeignClient.deactivateUser(userId);
        } catch (Exception e) {
            System.out.println("Error deactivating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createAccount(@RequestBody AccountDTO accountDTO) {
        try {
            this.accountUserFeignClient.createAccount(accountDTO);
        } catch (Exception e) {
            System.out.println("Error creating account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteAccount(@PathVariable Long accountId) {
        try {
            this.accountUserFeignClient.deleteAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateAccount(@PathVariable Long accountId) {
        try {
            this.accountUserFeignClient.updateAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error updating account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deactivateAccount(@PathVariable Long accountId) {
        try {
            this.accountUserFeignClient.deactivateAccount(accountId);
        } catch (Exception e) {
            System.out.println("Error deactivating account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Trip

    public void createTrip(TripDTO tripDTO) {
        try {
            this.tripFeignClient.createTrip(tripDTO);
        } catch (Exception e) {
            System.out.println("Error creating trip: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteTrip(Long tripId) {
        try {
            this.tripFeignClient.deleteTrip(tripId);
        } catch (Exception e) {
            System.out.println("Error deleting trip with ID: " + tripId);
            e.printStackTrace();
        }
    }

    public void createPrice(PriceDTO priceDTO) {
        try {
            this.tripFeignClient.createPrice(priceDTO);
        } catch (Exception e) {
            System.out.println("Error creating price: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //public void setExtraFee(@PathVariable Long priceId);
}
