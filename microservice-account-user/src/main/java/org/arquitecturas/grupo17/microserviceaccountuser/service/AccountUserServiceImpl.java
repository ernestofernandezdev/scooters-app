package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.AccountUserRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.utils.AccountUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserServiceImpl implements AccountUserService{

    @Autowired
    private final AccountUserRepository accountUserRepository;
    private final AccountUserMapper accountUserMapper = new AccountUserMapper();

    public AccountUserServiceImpl(AccountUserRepository accountUserRepository){
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public User create(UserDTO userDTO) {
        User accountUser = this.accountUserMapper.toEntity(userDTO);
        return accountUserRepository.save(accountUser);
    }

    @Override
    public User findById(Long id) {
        return accountUserRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> findAll() {
        return accountUserRepository.findAll();
    }

    @Override
    public User update(UserDTO userDTO, Long id) {
        User accountUser = this.findById(id);
        if(accountUser == null){
            return null;
        }
        this.accountUserMapper.updateEntityFromDTO(userDTO, accountUser);
        return accountUserRepository.save(accountUser);
    }

    @Override
    public void delete(Long id) {
        this.accountUserRepository.deleteById(id);
    }
}
