package org.arquitecturas.grupo17.microservicegateway;


import org.arquitecturas.grupo17.microservicegateway.client.AccountUserFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.ScooterFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.StopFeignClient;
import org.arquitecturas.grupo17.microservicegateway.client.TripFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.*;
import org.arquitecturas.grupo17.microservicegateway.service.MainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GatewayTests {
    @Mock
    private ScooterFeignClient scooterClient;
    @Mock
    private StopFeignClient stopClient;
    @Mock
    private AccountUserFeignClient accountUserClient;
    @Mock
    private TripFeignClient tripClient;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private MainService mainService;

    @Test
    void setScooterMaintenanceTEST() {
        when(scooterClient.setScooterMaintenance(1L))
                .thenReturn(ResponseEntity.ok().build());

        assertDoesNotThrow(() -> mainService.setScooterMaintenance(1L));
    }

    @Test
    void setScooterMaintenanceFailTEST() {
        when(scooterClient.setScooterMaintenance(1L))
                .thenReturn(ResponseEntity.badRequest().build());

        assertThrows(Exception.class, () -> mainService.setScooterMaintenance(1L));
    }

    @Test
    void endScooterMaintenanceTEST() {
        when(scooterClient.endScooterMaintenance(1L))
                .thenReturn(ResponseEntity.ok().build());

        assertDoesNotThrow(() -> mainService.endScooterMaintenance(1L));
    }

    @Test
    void endScooterMaintenanceFailTEST() {
        when(scooterClient.endScooterMaintenance(1L))
                .thenReturn(ResponseEntity.badRequest().build());

        assertThrows(Exception.class, () -> mainService.endScooterMaintenance(1L));
    }

    @Test
    void addScooterTEST() {
        ScooterDTO scooter = new ScooterDTO();
        when(scooterClient.createScooter(scooter))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.addScooter(scooter));
    }

    @Test
    void addScooterFailTEST() {
        ScooterDTO scooter = new ScooterDTO();
        when(scooterClient.createScooter(scooter))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.addScooter(scooter));
    }

    @Test
    void deleteScooterTEST() {
        when(scooterClient.deleteScooter(1))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.deleteScooter(1));
    }

    @Test
    void deleteScooterFailTEST() {
        when(scooterClient.deleteScooter(1))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.deleteScooter(1));
    }

    @Test
    void addStopTEST() {
        StopDTO stop = new StopDTO();
        when(stopClient.createStop(stop))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.addStop(stop));
    }

    @Test
    void addStopFailTEST() {
        StopDTO stop = new StopDTO();
        when(stopClient.createStop(stop))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.addStop(stop));
    }

    @Test
    void deleteStopTEST() {
        when(stopClient.deleteStop(1))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.deleteStop(1));
    }

    @Test
    void deleteStopFailTEST() {
        when(stopClient.deleteStop(1))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.deleteStop(1));
    }

    @Test
    void createPriceTEST() {
        PriceDTO price = new PriceDTO();
        when(tripClient.createPrice(price))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.createPrice(price));
    }

    @Test
    void createPriceFailTEST() {
        PriceDTO price = new PriceDTO();
        when(tripClient.createPrice(price))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.createPrice(price));
    }

    @Test
    void updatePenaltyPriceTEST() {
        when(tripClient.updatePenaltyPrice(1, 200))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.updatePenaltyPrice(1, 200));
    }

    @Test
    void updatePenaltyPriceFailTEST() {
        when(tripClient.updatePenaltyPrice(1, 200))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.updatePenaltyPrice(1, 200));
    }

    @Test
    void deactivateAccountTEST() {
        when(accountUserClient.deactivateAccount(1L))
                .thenReturn(ResponseEntity.ok().build());
        assertDoesNotThrow(() -> mainService.deactivateAccount(1L));
    }

    @Test
    void deactivateAccountFailTEST() {
        when(accountUserClient.deactivateAccount(1L))
                .thenReturn(ResponseEntity.badRequest().build());
        assertThrows(Exception.class, () -> mainService.deactivateAccount(1L));
    }

    @Test
    void getDistanceReportTEST() throws Exception {
        List<DistanceReportDTO> reports = new ArrayList<>();
        when(tripClient.getDistanceReport())
                .thenReturn(ResponseEntity.ok(reports));
        assertDoesNotThrow(() -> mainService.getDistanceReport());
        assertEquals(reports, mainService.getDistanceReport());
    }

    @Test
    void getTimeReportTEST() throws Exception {
        List<TimeReportDTO> reports = new ArrayList<>();
        when(tripClient.getTimeReport(true))
                .thenReturn(ResponseEntity.ok(reports));
        assertDoesNotThrow(() -> mainService.getTimeReport(true));
        assertEquals(reports, mainService.getTimeReport(true));
    }

    @Test
    void getScootersWithMoreThanXTripsInYearTEST() {
        List<ScooterTripsDTO> scooterTrips = new ArrayList<>();
        when(tripClient.getScootersWithMoreThanXTripsInYear(2024, 3))
                .thenReturn(ResponseEntity.ok(scooterTrips));
        assertDoesNotThrow(() -> mainService.getScootersWithMoreThanXTripsInYear(2024, 3));
        assertEquals(scooterTrips, mainService.getScootersWithMoreThanXTripsInYear(2024, 3));
    }

    @Test
    void getTotalBilledTEST() {
        int total = 1000;
        when(tripClient.getTotalBilled(2024, 2,7))
                .thenReturn(ResponseEntity.ok(total));
        assertDoesNotThrow(() -> mainService.getTotalBilled(2024, 2,7));
        assertEquals(total, mainService.getTotalBilled(2024, 2,7));
    }

    @Test
    void getScootersByStateTEST() {
        List<ScooterStateDTO> scooters = new ArrayList<>();
        when(scooterClient.getScooterStates())
                .thenReturn(ResponseEntity.ok(scooters));
        assertDoesNotThrow(() -> mainService.getScootersByState());
        assertEquals(scooters, mainService.getScootersByState());
    }

    @Test
    void getCloseScootersTEST() throws Exception {
        List<ScooterDTO> closeScooters = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setX(0);
        user.setY(0);
        when(accountUserClient.getUser(1L))
                .thenReturn(ResponseEntity.ok(user));
        when(scooterClient.getCloseScooters(0, 0, 10))
                .thenReturn(ResponseEntity.ok(closeScooters));
        assertDoesNotThrow(() -> mainService.getCloseScooters(1L, 10));
        assertEquals(closeScooters, mainService.getCloseScooters(1L, 10));
    }

}
