package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.AccountUserDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.UserAccount;
import org.arquitecturas.grupo17.microservicecuentausuario.repository.AccountUserRepository;
import org.arquitecturas.grupo17.microservicecuentausuario.utils.AccountUserMapper;
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
    public UserAccount create(AccountUserDTO accountUserDTO) {
        UserAccount accountUser = this.accountUserMapper.toEntity(accountUserDTO);
        return accountUserRepository.save(accountUser);
    }

    @Override
    public UserAccount findById(Long id) {
        return accountUserRepository.findById(id).orElseThrow();
    }

    @Override
    public List<UserAccount> findAll() {
        return accountUserRepository.findAll();
    }

    @Override
    public UserAccount update(AccountUserDTO accountUserDTO, Long id) {
        UserAccount accountUser = this.findById(id);
        if(accountUser == null){
            return null;
        }
        this.accountUserMapper.updateEntityFromDTO(accountUserDTO, accountUser);
        return accountUserRepository.save(accountUser);
    }

    @Override
    public void delete(Long id) {
        this.accountUserRepository.deleteById(id);
    }
}
