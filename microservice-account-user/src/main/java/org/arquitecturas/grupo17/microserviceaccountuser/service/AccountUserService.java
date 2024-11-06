package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;

import java.util.List;

public interface AccountUserService {
    User create(UserDTO userDTO);
    User findById(Long id);
    List<User> findAll();
    User update(UserDTO userDTO, Long id);
    void delete(Long id);
}
