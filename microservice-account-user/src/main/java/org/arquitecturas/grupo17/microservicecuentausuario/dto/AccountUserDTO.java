package org.arquitecturas.grupo17.microservicecuentausuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountUserDTO {
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private Integer x;
    private Integer y;
    private Integer role;
}
