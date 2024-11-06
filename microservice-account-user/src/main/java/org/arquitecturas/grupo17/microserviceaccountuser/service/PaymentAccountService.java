package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Account;

import java.util.List;


public interface PaymentAccountService {
    Account create(AccountDTO accountDTO);
    Account findById(Long id);
    List<Account> findAll();
    Account update(AccountDTO accountDTO, Long id);
    void delete(Long id);
}
