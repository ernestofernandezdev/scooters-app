package org.arquitecturas.grupo17.microserviceaccountuser.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccount;
    private double availableMoney;
    private boolean disabled;
    private Timestamp registrationDate;
    @ManyToMany
    private List<User> users;

    public Account(double availableMoney, Timestamp registrationDate) {
        this.availableMoney = availableMoney;
        this.registrationDate = registrationDate;
        this.disabled = false;
    }
}
