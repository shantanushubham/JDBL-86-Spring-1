package org.geeksforgeeks.jdbl86.jdbc;

import org.geeksforgeeks.jdbl86.mapper.EmployeeRowMapper;
import org.geeksforgeeks.jdbl86.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    private static final Connection connection = MyDBConnection.getConnection();

    public static void main(String[] args) throws SQLException {
        try {
//        String ddlCommand = "CREATE TABLE employees ("
//                + "id SERIAL PRIMARY KEY, "
//                + "name VARCHAR(100), "
//                + "department VARCHAR(50)"
//                + ")";
//        runUpdate(ddlCommand);
//            addEmployee(new Employee("Risheepriya", "Bank"));
            System.out.println(getAllEmployees());
        } finally {
            connection.close();
        }
    }

    public static void addEmployee(Employee e) {
        // VALUES ('Shantanu', 'IT')
        addEmployeeToDB(e);
    }

    public static void runUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            System.out.println(e);
        }
    }

    public static int addEmployeeToDB(Employee e) {
        String query = "INSERT INTO employees (name, department) VALUES (?, ?)";
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, e.getName());
                preparedStatement.setString(2, e.getDepartment());
                int rows = preparedStatement.executeUpdate();
                System.out.println("Connected to PostgreSQL database!");
                System.out.println(rows + " rows returned");
                return rows;
            }
        } catch (SQLException ex) {
            System.out.println("Database connection failed");
            System.out.println(ex);
            return 0;
        }
    }

    public static ResultSet runQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery(query);
            System.out.println("Connected to PostgreSQL database!");
            return r;
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            System.out.println(e);
            return null;
        }
    }

    public static List<Employee> getAllEmployees() throws SQLException {
        String fetch = "SELECT * FROM employees";
        ResultSet r = runQuery(fetch);
        List<Employee> list = new ArrayList<>();
        EmployeeRowMapper rowMapper = new EmployeeRowMapper();
        int i = 1;
        while (r != null && r.next()) {
            list.add(rowMapper.mapRow(r, i++));
        }
        return list;
    }
}

// Task 1:
// Write a function that uses prepared statement to delete a employee from DB by ID.
// Functional param: Employee e
// Return type: void
