package com.library.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("ALL")
public class DatabaseConnection {
    public DatabaseConnection() {
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String schema = "mylms";
        String password = "975897";

        try {
            Connection connection = DriverManager.getConnection(url, "root", password);

            try {
                if (connection != null) {
                    System.out.println("Congratulations, you are Connected to the database Successfully !");

                    // Switch to the specified schema
                    try (Statement statement = connection.createStatement()) {
                        statement.execute("USE " + schema);
                        System.out.println("Switched to schema: " + schema);
                    }
                }
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var9) {
            SQLException e = var9;
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}














































































