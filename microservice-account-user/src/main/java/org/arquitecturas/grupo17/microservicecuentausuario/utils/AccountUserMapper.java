package org.arquitecturas.grupo17.microservicecuentausuario.utils;

import lombok.NoArgsConstructor;
import org.arquitecturas.grupo17.microservicecuentausuario.dto.AccountUserDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.AccountUser;

@NoArgsConstructor
public class AccountUserMapper {

    public AccountUserDTO toDTO(AccountUser accountUser){
        if(accountUser == null){
            return null;
        }
        return new AccountUserDTO(
                accountUser.getName(),
                accountUser.getLastName(),
                accountUser.getUserName(),
                accountUser.getEmail(),
                accountUser.getPhoneNumber(),
                accountUser.getX(),
                accountUser.getY(),
                accountUser.getRole()
        );
    }

    public AccountUser toEntity(AccountUserDTO accountUserDTO){
        if(accountUserDTO == null){
            return null;
        }
        return new AccountUser(
                accountUserDTO.getName(),
                accountUserDTO.getLastName(),
                accountUserDTO.getUserName(),
                accountUserDTO.getEmail(),
                accountUserDTO.getPhoneNumber(),
                accountUserDTO.getX(),
                accountUserDTO.getY(),
                accountUserDTO.getRole()
        );
    }

    public void updateEntityFromDTO(AccountUserDTO accountUserDTO, AccountUser accountUser) {
        if (accountUserDTO.getName() != null) {
            accountUser.setName(accountUserDTO.getName());
        }
        if (accountUserDTO.getLastName() != null) {
            accountUser.setLastName(accountUserDTO.getLastName());
        }
        if (accountUserDTO.getUserName() != null) {
            accountUser.setUserName(accountUserDTO.getUserName());
        }
        if (accountUserDTO.getEmail() != null) {
            accountUser.setEmail(accountUserDTO.getEmail());
        }
        if (accountUserDTO.getPhoneNumber() != null) {
            accountUser.setPhoneNumber(accountUserDTO.getPhoneNumber());
        }
        if (accountUserDTO.getX() != null) {
            accountUser.setX(accountUserDTO.getX());
        }
        if (accountUserDTO.getY() != null) {
            accountUser.setY(accountUserDTO.getY());
        }
        if (accountUserDTO.getRole() != null) {
            accountUser.setRole(accountUserDTO.getRole());
        }
    }
}
