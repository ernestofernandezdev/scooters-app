package org.arquitecturas.grupo17.microservicecuentausuario.service;

import org.arquitecturas.grupo17.microservicecuentausuario.dto.AccountUserDTO;
import org.arquitecturas.grupo17.microservicecuentausuario.model.AccountUser;
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
    public AccountUser create(AccountUserDTO accountUserDTO) {
        AccountUser accountUser = this.accountUserMapper.toEntity(accountUserDTO);
        return accountUserRepository.save(accountUser);
    }

    @Override
    public AccountUser findById(Long id) {
        return accountUserRepository.findById(id).orElseThrow();
    }

    @Override
    public List<AccountUser> findAll() {
        return accountUserRepository.findAll();
    }

    @Override
    public AccountUser update(AccountUserDTO accountUserDTO, Long id) {
        AccountUser accountUser = this.findById(id);
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
