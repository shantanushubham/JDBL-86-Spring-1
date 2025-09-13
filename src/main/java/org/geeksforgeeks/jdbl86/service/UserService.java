package org.geeksforgeeks.jdbl86.service;

import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.repository.impl.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity userEntity) {
        return this.userRepository.addUser(userEntity);
    }
}
