package org.arquitecturas.grupo17.microserviceaccountuser.utils;

import lombok.NoArgsConstructor;
import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Role;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper {

    private final RoleRepository roleRepository;

    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserDTO toDTO(User user){
        if(user == null){
            return null;
        }
        return new UserDTO(
                user.getFirstname(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getX(),
                user.getY(),
                user.getRoles().stream().map(Role::getName).toList()
        );
    }

    public User toEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }
        User user = new User(
                userDTO.getFirstname(),
                userDTO.getLastName(),
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber(),
                userDTO.getX(),
                userDTO.getY()
        );

        userDTO.getRoles()
                .forEach(role -> user.addRole(this.roleRepository.findById(role).orElseThrow()));

        return user;
    }

    public void updateEntityFromDTO(UserDTO userDTO, User user) {
        if (userDTO.getFirstname() != null) {
            user.setFirstname(userDTO.getFirstname());
        }
        if (userDTO.getLastName() != null) {
            user.setLastName(userDTO.getLastName());
        }
        if (userDTO.getUserName() != null) {
            user.setUserName(userDTO.getUserName());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userDTO.getPhoneNumber());
        }
        if (userDTO.getX() != null) {
            user.setX(userDTO.getX());
        }
        if (userDTO.getY() != null) {
            user.setY(userDTO.getY());
        }
        user.setRoles(new ArrayList<>());
        userDTO.getRoles().forEach(role -> user.addRole(new Role(role)));

    }
}
