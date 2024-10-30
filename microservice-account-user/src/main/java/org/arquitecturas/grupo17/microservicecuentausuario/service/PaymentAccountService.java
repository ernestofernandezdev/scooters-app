package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.PaymentAccountDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.PaymentAccount;

import java.util.List;


public interface PaymentAccountService {
    PaymentAccount create(PaymentAccountDTO paymentAccountDTO);
    PaymentAccount findById(Long id);
    List<PaymentAccount> findAll();
    PaymentAccount update(PaymentAccountDTO paymentAccountDTO, Long id);
    void delete(Long id);
}
