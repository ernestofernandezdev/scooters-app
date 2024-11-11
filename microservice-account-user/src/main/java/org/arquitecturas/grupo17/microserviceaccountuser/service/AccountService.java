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

    public AccountDTO findById(long id) {
        return this.accountMapper.toDTO(accountRepository.findById(id).orElseThrow());
    }

    public List<AccountDTO> findAll() {
        return this.accountRepository.findAll().stream()
                .map(this.accountMapper::toDTO)
                .toList();
    }

    public void update(AccountDTO accountDTO, long id) {
        Account account = this.accountRepository.findById(id).orElseThrow();
        this.accountMapper.updateEntityFromDTO(accountDTO, account);
        this.accountRepository.save(account);
    }

    public void delete(long id) {
        this.accountRepository.deleteById(id);
    }

    public void deactivate(long id) throws Exception {
        Account account = this.accountRepository.findById(id).orElseThrow();
        account.setDisabled(true);
        this.accountRepository.save(account);
    }
}
