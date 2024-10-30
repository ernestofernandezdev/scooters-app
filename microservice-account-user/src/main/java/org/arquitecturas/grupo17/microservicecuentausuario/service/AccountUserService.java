package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.AccountUserDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.AccountUser;

import java.util.List;

public interface AccountUserService {
    AccountUser create(AccountUserDTO accountUserDTO);
    AccountUser findById(Long id);
    List<AccountUser> findAll();
    AccountUser update(AccountUserDTO accountUserDTO, Long id);
    void delete(Long id);
}
