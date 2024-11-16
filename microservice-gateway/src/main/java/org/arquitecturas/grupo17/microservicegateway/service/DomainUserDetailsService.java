package org.arquitecturas.grupo17.microservicegateway.service;

import org.arquitecturas.grupo17.microservicegateway.client.AccountUserFeignClient;
import org.arquitecturas.grupo17.microservicegateway.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final AccountUserFeignClient accountUserFeignClient;

    public DomainUserDetailsService( AccountUserFeignClient accountUserFeignClient ) {
        this.accountUserFeignClient = accountUserFeignClient;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username ) {
        log.debug("Authenticating {}", username);

        return this.createSpringSecurityUser(
                Objects.requireNonNull(this.accountUserFeignClient
                        .getUserByUsername(username.toLowerCase())
                        .getBody())
        );
    }

    private UserDetails createSpringSecurityUser( UserDTO user ) {
        List<GrantedAuthority> grantedAuthorities = user
                .getRoles()
                .stream()
                .map( SimpleGrantedAuthority::new )
                .collect( Collectors.toList() );
        return new org.springframework.security.core.userdetails.User( user.getUserName(), user.getPassword(), grantedAuthorities );
    }
}
