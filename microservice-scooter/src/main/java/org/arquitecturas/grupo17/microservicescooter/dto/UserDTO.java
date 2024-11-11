package org.arquitecturas.grupo17.microservicescooter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private Integer x;
    private Integer y;
    private String role;
}
