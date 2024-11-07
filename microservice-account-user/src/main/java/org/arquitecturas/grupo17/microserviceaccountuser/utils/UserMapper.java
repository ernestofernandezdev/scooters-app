package org.arquitecturas.grupo17.microserviceaccountuser.utils;

import lombok.NoArgsConstructor;
import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Role;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;

@NoArgsConstructor
public class UserMapper {

    public UserDTO toDTO(User accountUser){
        if(accountUser == null){
            return null;
        }
        return new UserDTO(
                accountUser.getFirstname(),
                accountUser.getLastName(),
                accountUser.getUserName(),
                accountUser.getEmail(),
                accountUser.getPhoneNumber(),
                accountUser.getX(),
                accountUser.getY(),
                accountUser.getRole().getName()
        );
    }

    public User toEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }
        return new User(
                userDTO.getFirstname(),
                userDTO.getLastName(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber(),
                userDTO.getX(),
                userDTO.getY(),
                userDTO.getRole()
        );
    }

    public void updateEntityFromDTO(UserDTO userDTO, User accountUser) {
        if (userDTO.getFirstname() != null) {
            accountUser.setFirstname(userDTO.getFirstname());
        }
        if (userDTO.getLastName() != null) {
            accountUser.setLastName(userDTO.getLastName());
        }
        if (userDTO.getUserName() != null) {
            accountUser.setUserName(userDTO.getUserName());
        }
        if (userDTO.getEmail() != null) {
            accountUser.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPhoneNumber() != null) {
            accountUser.setPhoneNumber(userDTO.getPhoneNumber());
        }
        if (userDTO.getX() != null) {
            accountUser.setX(userDTO.getX());
        }
        if (userDTO.getY() != null) {
            accountUser.setY(userDTO.getY());
        }
        if (userDTO.getRole() != null) {
            accountUser.setRole(new Role(userDTO.getRole()));
        }
    }
}
