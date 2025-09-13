package org.geeksforgeeks.jdbl86.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonDeserialize
@JsonSerialize

@Data
public class EmployeeDto {

    private String name;
    private int departmentId;

}
