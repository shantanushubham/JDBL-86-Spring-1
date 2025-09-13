package org.geeksforgeeks.jdbl86.repository.jpa;

import org.geeksforgeeks.jdbl86.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJPARepository extends JpaRepository<DepartmentEntity, Integer> {
}
