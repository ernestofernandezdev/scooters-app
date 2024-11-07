package org.arquitecturas.grupo17.microserviceaccountuser.utils;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Account;

public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDTO(
                account.getAvailableMoney(),
                account.getRegistrationDate()
        );
    }

    public Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        return new Account(
                accountDTO.getAvailableMoney(),
                accountDTO.getRegistrationDate()
        );
    }

    public void updateEntityFromDTO(AccountDTO accountDTO, Account account) {
        if (accountDTO.getAvailableMoney() != 0) {
            account.setAvailableMoney(accountDTO.getAvailableMoney());
        }
        if (accountDTO.getRegistrationDate() != null) {
            account.setRegistrationDate(accountDTO.getRegistrationDate());
        }
    }

}
