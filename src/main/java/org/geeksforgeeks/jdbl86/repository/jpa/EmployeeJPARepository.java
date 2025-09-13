package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeJPARepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByName(String name);
}
