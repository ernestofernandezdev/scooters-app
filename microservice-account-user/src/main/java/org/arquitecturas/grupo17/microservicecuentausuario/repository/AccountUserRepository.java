package org.arquitecturas.grupo17.microservicecuentausuario.repository;

import org.arquitecturas.grupo17.microservicecuentausuario.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<UserAccount, Long> {
}
