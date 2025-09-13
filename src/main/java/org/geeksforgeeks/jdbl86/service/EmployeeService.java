package org.geeksforgeeks.jdbl86.service;

import org.geeksforgeeks.jdbl86.entity.EmployeeEntity;
import org.geeksforgeeks.jdbl86.repository.impl.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        return this.employeeRepository.saveEmployee(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(int id) {
        return this.employeeRepository.getById(id);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return this.employeeRepository.saveEmployee(employeeEntity);
    }

    public void deleteEmployeeById(int id) {
        this.employeeRepository.deleteEmployee(id);
    }

}
