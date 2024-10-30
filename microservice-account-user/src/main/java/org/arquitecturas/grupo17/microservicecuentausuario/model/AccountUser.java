package org.arquitecturas.grupo17.microservicecuentausuario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUser {
    public static final int NORMAL_USER = 0;
    public static final int ADMIN_USER = 1;
    public static final int MAINTENANCE_USER = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccountUser;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private Integer x;
    private Integer y;
    private Integer role;

    public AccountUser(String name, String lastName, String userName, String email, String phoneNumber, Integer x, Integer y, Integer role) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.x = x;
        this.y = y;
        this.role = role;
    }
}
