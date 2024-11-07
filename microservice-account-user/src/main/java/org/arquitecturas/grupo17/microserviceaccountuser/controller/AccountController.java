package org.arquitecturas.grupo17.microserviceaccountuser.controller;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public ResponseEntity<List<AccountDTO>> findAll() {
        return ResponseEntity.ok(this.accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable("id") Long id) {
        AccountDTO accountDto = this.accountService.findById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody AccountDTO accountDto) {
        accountService.create(accountDto);
        return ResponseEntity.ok("Account created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AccountDTO accountDto) {
        accountService.update(accountDto, id);
        return ResponseEntity.ok("Account updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.ok("Account deleted");
    }
}
