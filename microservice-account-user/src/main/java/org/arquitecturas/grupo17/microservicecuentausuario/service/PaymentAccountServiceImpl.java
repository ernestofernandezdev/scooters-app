package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.PaymentAccountDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.PaymentAccount;
import org.arquitecturas.grupo17.microservicecuentausuario.repository.PaymentAccountRepository;
import org.arquitecturas.grupo17.microservicecuentausuario.utils.PaymentAccountMapper;
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
    public PaymentAccount create(PaymentAccountDTO paymentAccountDTO) {
        PaymentAccount paymentAccount = paymentAccountMapper.toEntity(paymentAccountDTO);
        return this.paymentAccountRepository.save(paymentAccount);
    }

    @Override
    public PaymentAccount findById(Long id) {
        return this.paymentAccountRepository.findById(id).orElseThrow();
    }

    @Override
    public List<PaymentAccount> findAll() {
        return this.paymentAccountRepository.findAll();
    }

    @Override
    public PaymentAccount update(PaymentAccountDTO paymentAccountDTO, Long id) {
        PaymentAccount paymentAccount = this.findById(id);
        if(paymentAccount == null){
            return null;
        }
        this.paymentAccountMapper.updateEntityFromDTO(paymentAccountDTO, paymentAccount);
        return paymentAccount;
    }

    @Override
    public void delete(Long id) {
        this.paymentAccountRepository.deleteById(id);
    }
}
