package org.arquitecturas.grupo17.microservicecuentausuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class PaymentAccountDTO {
    private double avaibleMoney;
    private Timestamp registrationDate;
}
