package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.AccountUserDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.UserAccount;

import java.util.List;

public interface AccountUserService {
    UserAccount create(AccountUserDTO accountUserDTO);
    UserAccount findById(Long id);
    List<UserAccount> findAll();
    UserAccount update(AccountUserDTO accountUserDTO, Long id);
    void delete(Long id);
}
