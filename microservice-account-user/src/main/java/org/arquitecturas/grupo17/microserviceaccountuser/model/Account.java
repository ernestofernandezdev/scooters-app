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
    private Long idPaymentAccount;
    private double avaibleMoney;
    private Timestamp registrationDate;
    @ManyToMany
    private List<User> userList;

    public Account(double avaibleMoney, Timestamp registrationDate) {
        this.avaibleMoney = avaibleMoney;
        this.registrationDate = registrationDate;
    }
}
