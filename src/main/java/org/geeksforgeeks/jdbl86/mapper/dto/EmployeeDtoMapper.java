package org.geeksforgeeks.jdbl86.mapper.dto;

import org.geeksforgeeks.jdbl86.dto.EmployeeDto;
import org.geeksforgeeks.jdbl86.entity.DepartmentEntity;
import org.geeksforgeeks.jdbl86.entity.EmployeeEntity;
import org.geeksforgeeks.jdbl86.repository.impl.DepartmentRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper {

    private final DepartmentRepository departmentRepository;

    public EmployeeDtoMapper(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public EmployeeEntity toEntity(EmployeeDto employeeDto) {
        DepartmentEntity departmentEntity = this.departmentRepository
                .getById(employeeDto.getDepartmentId());
        return EmployeeEntity.builder()
                .name(employeeDto.getName())
                .departmentEntity(departmentEntity)
                .build();
    }
}
