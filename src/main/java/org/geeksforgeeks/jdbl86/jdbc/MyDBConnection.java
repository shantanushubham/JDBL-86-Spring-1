package org.geeksforgeeks.jdbl86.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {

    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, user, password);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

// HikariCP, Apache DBCP, C3P0
