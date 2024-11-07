package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Account;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.AccountRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.utils.AccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper = new AccountMapper();

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void create(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        this.accountRepository.save(account);
    }

    public AccountDTO findById(Long id) {
        return this.accountMapper.toDTO(accountRepository.findById(id).orElseThrow());
    }

    public List<AccountDTO> findAll() {
        return this.accountRepository.findAll().stream()
                .map(this.accountMapper::toDTO)
                .toList();
    }

    public void update(AccountDTO accountDTO, Long id) {
        Account account = this.accountRepository.findById(id).orElseThrow();
        this.accountMapper.updateEntityFromDTO(accountDTO, account);
        this.accountRepository.save(account);
    }

    public void delete(Long id) {
        this.accountRepository.deleteById(id);
    }
}
