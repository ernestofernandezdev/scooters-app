package org.arquitecturas.grupo17.microservicegateway.client;

import org.arquitecturas.grupo17.microservicegateway.dto.AccountDTO;
import org.arquitecturas.grupo17.microservicegateway.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-account-user")
public interface AccountUserFeignClient {

    //User
    @GetMapping("/api/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id);

    @PostMapping("/api/user")
    ResponseEntity<String> createUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/api/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable long id);

    @PutMapping("/api/user/{id}")
    ResponseEntity<String> updateUser(@PathVariable long id);

    @PutMapping("/api/deactivated-user/{id}")
    ResponseEntity<String> deactivateUser(@PathVariable long id);

    //Payment Account

    @PostMapping("/api/user/account")
    ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO);

    @DeleteMapping("/api/user/account/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable long id);

    @PutMapping("/api/user/account/{id}")
    ResponseEntity<String> updateAccount(@PathVariable long id);

    @PutMapping("/api/account/deactivate-account/{id}")
    ResponseEntity<String> deactivateAccount(@PathVariable long id);
}
