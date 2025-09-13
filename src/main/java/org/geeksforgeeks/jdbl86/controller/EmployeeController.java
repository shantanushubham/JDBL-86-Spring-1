package org.geeksforgeeks.jdbl86.controller;

import org.geeksforgeeks.jdbl86.dto.EmployeeDto;
import org.geeksforgeeks.jdbl86.entity.EmployeeEntity;
import org.geeksforgeeks.jdbl86.mapper.dto.EmployeeDtoMapper;
import org.geeksforgeeks.jdbl86.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDtoMapper employeeDtoMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeDtoMapper employeeDtoMapper) {
        this.employeeService = employeeService;
        this.employeeDtoMapper = employeeDtoMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = this.employeeDtoMapper.toEntity(employeeDto);
        EmployeeEntity savedEmployeeEntity = this.employeeService.addEmployee(employeeEntity);
        return new ResponseEntity<>(savedEmployeeEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        EmployeeEntity employeeEntity = this.employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity updatedEmployeeEntity = this.employeeService.updateEmployee(employeeEntity);
        return new ResponseEntity<>(updatedEmployeeEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
