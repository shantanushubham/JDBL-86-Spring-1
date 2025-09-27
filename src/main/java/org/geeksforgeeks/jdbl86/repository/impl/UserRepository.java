package org.geeksforgeeks.jdbl86.repository.impl;

import jakarta.validation.ConstraintViolationException;
import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.execptions.DuplicateEntryException;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.jpa.UserJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final UserJPARepository userJPARepository;

    public UserRepository(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public UserEntity addUser(UserEntity userEntity) {
        try {
            return this.userJPARepository.save(userEntity);
        } catch (ConstraintViolationException exception) {
            throw new DuplicateEntryException(exception.getMessage());
        }
    }

    public UserEntity getUserById(int userId) {
        return this.userJPARepository.findById(userId).orElseThrow(() ->
                new NotFoundException(UserEntity.class, "id", userId));
    }

    public UserEntity getUserByEmail(String email) {
        return this.userJPARepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException(UserEntity.class, "email", email));
    }
}
