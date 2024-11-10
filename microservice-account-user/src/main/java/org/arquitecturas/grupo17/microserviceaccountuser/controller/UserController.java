package org.arquitecturas.grupo17.microserviceaccountuser.controller;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") long id) {
        UserDTO userDto = this.userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody UserDTO userDto) {
        userService.create(userDto);
        return ResponseEntity.ok("User created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody UserDTO userDto) {
        userService.update(userDto, id);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }
}
