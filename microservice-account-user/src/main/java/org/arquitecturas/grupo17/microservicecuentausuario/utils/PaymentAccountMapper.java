package org.arquitecturas.grupo17.microservicecuentausuario.utils;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.PaymentAccountDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.PaymentAccount;

public class PaymentAccountMapper {
    public PaymentAccountDTO toDTO(PaymentAccount paymentAccount) {
        if (paymentAccount == null) {
            return null;
        }
        return new PaymentAccountDTO(
                paymentAccount.getAvaibleMoney(),
                paymentAccount.getRegistrationDate()
        );
    }

    public PaymentAccount toEntity(PaymentAccountDTO paymentAccountDTO) {
        if (paymentAccountDTO == null) {
            return null;
        }
        return new PaymentAccount(
                paymentAccountDTO.getAvaibleMoney(),
                paymentAccountDTO.getRegistrationDate()
        );
    }

    public void updateEntityFromDTO(PaymentAccountDTO paymentAccountDTO, PaymentAccount paymentAccount) {
        if (paymentAccountDTO.getAvaibleMoney() != 0) {
            paymentAccount.setAvaibleMoney(paymentAccountDTO.getAvaibleMoney());
        }
        if (paymentAccountDTO.getRegistrationDate() != null) {
            paymentAccount.setRegistrationDate(paymentAccountDTO.getRegistrationDate());
        }
    }

}
