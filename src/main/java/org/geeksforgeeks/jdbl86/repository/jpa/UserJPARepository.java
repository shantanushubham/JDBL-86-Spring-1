package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {
}
