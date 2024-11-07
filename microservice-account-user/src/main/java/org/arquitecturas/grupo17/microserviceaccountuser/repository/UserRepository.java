package org.arquitecturas.grupo17.microserviceaccountuser.repository;

import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
