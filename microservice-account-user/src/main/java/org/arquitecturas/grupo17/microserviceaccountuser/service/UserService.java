package org.arquitecturas.grupo17.microserviceaccountuser.service;

import org.arquitecturas.grupo17.microserviceaccountuser.dto.UserDTO;
import org.arquitecturas.grupo17.microserviceaccountuser.model.User;
import org.arquitecturas.grupo17.microserviceaccountuser.repository.UserRepository;
import org.arquitecturas.grupo17.microserviceaccountuser.utils.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = new UserMapper();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void create(UserDTO userDTO) {
        User accountUser = this.userMapper.toEntity(userDTO);
        userRepository.save(accountUser);
    }

    public UserDTO findById(long id) {
        return this.userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this.userMapper::toDTO)
                .toList();
    }

    public void update(UserDTO userDTO, long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userMapper.updateEntityFromDTO(userDTO, user);
        this.userRepository.save(user);
    }

    public void delete(long id) {
        this.userRepository.deleteById(id);
    }
}
