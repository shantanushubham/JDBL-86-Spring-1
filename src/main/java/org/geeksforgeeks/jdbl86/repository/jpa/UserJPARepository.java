package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

}
