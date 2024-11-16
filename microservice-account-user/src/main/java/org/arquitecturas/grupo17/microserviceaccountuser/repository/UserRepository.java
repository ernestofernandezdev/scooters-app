package org.arquitecturas.grupo17.microserviceaccountuser.repository;

import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
            select u from User u join fetch u.roles r
            where lower(u.userName) = ?1
""")
    Optional<User> findByUsernameWithRoles(String username);
}
