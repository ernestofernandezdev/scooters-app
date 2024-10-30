package org.arquitecturas.grupo17.microservicecuentausuario.model;

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
public class PaymentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaymentAccount;
    private double avaibleMoney;
    private Timestamp registrationDate;
    @ManyToMany
    private List<UserAccount> userAccountList;

    public PaymentAccount(double avaibleMoney, Timestamp registrationDate) {
        this.avaibleMoney = avaibleMoney;
        this.registrationDate = registrationDate;
    }
}
