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
    public ResponseEntity<AccountDTO> findById(@PathVariable("id") long id) {
        AccountDTO accountDto = this.accountService.findById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody AccountDTO accountDto) {
        accountService.create(accountDto);
        return ResponseEntity.ok("Account created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody AccountDTO accountDto) {
        accountService.update(accountDto, id);
        return ResponseEntity.ok("Account updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        accountService.delete(id);
        return ResponseEntity.ok("Account deleted");
    }

    @PutMapping("/deactivate-account/{accountId}")
    public ResponseEntity<String> deactivateAccount(@PathVariable long accountId) {
        try {
            this.accountService.deactivate(accountId);
            return ResponseEntity.ok("Account deactivated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Operation failed");
        }
    }
}
