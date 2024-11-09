package org.arquitecturas.grupo17.microserviceaccountuser.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccountUser;
    private String firstname;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private Integer x;
    private Integer y;
    @ManyToMany(mappedBy = "users")
    private List<Account> accounts;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Role role;

    public User(String firstname, String lastName, String userName, String email, String phoneNumber, Integer x, Integer y, String role) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.x = x;
        this.y = y;
        this.role = new Role(role);
    }
}
