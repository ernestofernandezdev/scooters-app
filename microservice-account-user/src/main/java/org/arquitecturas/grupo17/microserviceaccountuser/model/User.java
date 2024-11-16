package org.arquitecturas.grupo17.microserviceaccountuser.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private String password;
    private String email;
    private String phoneNumber;
    private Integer x;
    private Integer y;
    @ManyToMany(mappedBy = "users")
    private List<Account> accounts;
    @ManyToMany(cascade = {CascadeType.MERGE})
    private List<Role> roles;

    public User(String firstname, String lastName, String userName, String password, String email, String phoneNumber, Integer x, Integer y) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.x = x;
        this.y = y;
        this.roles = new ArrayList<>();
    }

    public void addRole(Role role) {
        if (!roles.contains(role) && (
                Objects.equals(role.getName(), Role._USER)
                || Objects.equals(role.getName(), Role._ADMIN)
                || Objects.equals(role.getName(), Role._MAINTENANCE)
                )) {
            roles.add(role);
        }
    }

    public boolean hasRole(String roleName) {
        return roles.stream().anyMatch(role -> role.getName().equals(roleName));
    }
}
