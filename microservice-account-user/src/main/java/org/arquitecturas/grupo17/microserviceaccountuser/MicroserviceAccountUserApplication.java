package org.arquitecturas.grupo17.microserviceaccountuser;

import org.arquitecturas.grupo17.microserviceaccountuser.model.Role;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.AccountRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.RoleRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAccountUserApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public MicroserviceAccountUserApplication(RoleRepository roleRepository, UserRepository userRepository, AccountRepository accountRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAccountUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.roleRepository.save(new Role(Role._USER));
        this.roleRepository.save(new Role(Role._ADMIN));
        this.roleRepository.save(new Role(Role._MAINTENANCE));

        User user = new User("Ernesto", "Fernández", "user", "$2a$10$nmyagiuwvV3B7PPuOpMWS.lpd9KluKJ1lPa9tUUHCxZUwaLPnDUqu", "fernandez.ernes@gmail.com", "123456", 0, 0);
        user.addRole(this.roleRepository.findById(Role._USER).orElseThrow());
        user.addRole(this.roleRepository.findById(Role._ADMIN).orElseThrow());
        this.userRepository.save(user);
    }
}
