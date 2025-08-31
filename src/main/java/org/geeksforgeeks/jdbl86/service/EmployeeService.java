package org.geeksforgeeks.jdbl86.service;

import jakarta.transaction.Transactional;
import org.geeksforgeeks.jdbl86.model.Employee;
import org.geeksforgeeks.jdbl86.repository.impl.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.saveEmployee(employee);
    }

    public Employee getEmployeeById(int id) {
        return this.employeeRepository.getById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.saveEmployee(employee);
    }

    public void deleteEmployeeById(int id) {
        this.employeeRepository.deleteEmployee(id);
    }

    @Transactional
    public void transactionExample() {
        this.addEmployee(new Employee(0, "Tanishqa", "Bank"));
        this.deleteEmployeeById(2);
    }
}
