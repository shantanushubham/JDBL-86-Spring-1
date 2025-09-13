package org.geeksforgeeks.jdbl86.repository.impl;

import org.geeksforgeeks.jdbl86.entity.DepartmentEntity;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.jpa.DepartmentJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    private final DepartmentJPARepository departmentJPARepository;

    public DepartmentRepository(DepartmentJPARepository departmentJPARepository) {
        this.departmentJPARepository = departmentJPARepository;
    }

    public DepartmentEntity getById(int id) {
        return this.departmentJPARepository.findById(id).orElseThrow(() ->
                new NotFoundException(DepartmentEntity.class, "id", id));
    }
}
