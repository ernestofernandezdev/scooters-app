package org.arquitecturas.grupo17.microserviceaccountuser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class AccountDTO {
    private double availableMoney;
    private Timestamp registrationDate;
}
