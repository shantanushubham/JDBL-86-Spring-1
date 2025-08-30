package org.geeksforgeeks.jdbl86.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String department;

}
