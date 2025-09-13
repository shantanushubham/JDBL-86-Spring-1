package org.geeksforgeeks.jdbl86.repository.impl;

import org.geeksforgeeks.jdbl86.entity.EmployeeEntity;
import org.geeksforgeeks.jdbl86.repository.jpa.EmployeeJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final EmployeeJPARepository employeeJPARepository;

    public EmployeeRepository(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

    // CREATE + UPDATE (Upsert)
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return this.employeeJPARepository.save(employeeEntity);
    }

    // READ/RETRIEVE
    public EmployeeEntity getById(int id) {
        return this.employeeJPARepository.findById(id).orElse(null);
    }

    // READ/RETRIEVE
    public EmployeeEntity getByName(String name) {
        return this.employeeJPARepository.findByName(name).orElse(null);
    }

    // DELETE
    public void deleteEmployee(int id) {
        this.employeeJPARepository.deleteById(id);
    }

    public void deleteEmployeesById(List<Integer> employeeIdList) {
        this.employeeJPARepository.deleteAllById(employeeIdList);
    }
}
