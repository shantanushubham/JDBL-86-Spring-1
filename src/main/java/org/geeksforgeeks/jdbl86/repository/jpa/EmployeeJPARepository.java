package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByName(String name);
}
