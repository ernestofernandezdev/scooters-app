package org.arquitecturas.grupo17.microservicecuentausuario.repository;

import org.arquitecturas.grupo17.microservicecuentausuario.model.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Long> {
}
