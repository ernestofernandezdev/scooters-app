package org.arquitecturas.grupo17.microserviceaccountuser.utils;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Account;

public class PaymentAccountMapper {
    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDTO(
                account.getAvaibleMoney(),
                account.getRegistrationDate()
        );
    }

    public Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        return new Account(
                accountDTO.getAvaibleMoney(),
                accountDTO.getRegistrationDate()
        );
    }

    public void updateEntityFromDTO(AccountDTO accountDTO, Account account) {
        if (accountDTO.getAvaibleMoney() != 0) {
            account.setAvaibleMoney(accountDTO.getAvaibleMoney());
        }
        if (accountDTO.getRegistrationDate() != null) {
            account.setRegistrationDate(accountDTO.getRegistrationDate());
        }
    }

}
