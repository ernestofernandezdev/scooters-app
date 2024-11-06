package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.AccountDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.Account;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.PaymentAccountRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.utils.PaymentAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService{

    @Autowired
    private final PaymentAccountRepository paymentAccountRepository;
    private final PaymentAccountMapper paymentAccountMapper = new PaymentAccountMapper();

    public PaymentAccountServiceImpl(PaymentAccountRepository paymentAccountRepository) {
        this.paymentAccountRepository = paymentAccountRepository;
    }

    @Override
    public Account create(AccountDTO accountDTO) {
        Account account = paymentAccountMapper.toEntity(accountDTO);
        return this.paymentAccountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return this.paymentAccountRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Account> findAll() {
        return this.paymentAccountRepository.findAll();
    }

    @Override
    public Account update(AccountDTO accountDTO, Long id) {
        Account account = this.findById(id);
        if(account == null){
            return null;
        }
        this.paymentAccountMapper.updateEntityFromDTO(accountDTO, account);
        return account;
    }

    @Override
    public void delete(Long id) {
        this.paymentAccountRepository.deleteById(id);
    }
}
