package org.example;
import java.sql.*;

public class userDAO {
    public static void main(String[] args) {

        System.out.print("Hello !  Welcome to the Library Management System DATABASE CONNECTIVITY");

    }

    public static class UserDAO {
        private static final String URL = "jdbc:mysql://localhost:3306/?user=root";
        private static final String USER = "root@localhost:3306";
        private static final String PASSWORD = "975897";

        private Connection connect() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public boolean addUser(String name, String email) {
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public boolean updateUser(int userId, String name, String email) {
            String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setInt(3, userId);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public boolean deleteUser(int userId) {
            String query = "DELETE FROM users WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, userId);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public void getUser(int userId) {
            String query = "SELECT * FROM users WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("User ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Email: " + rs.getString("email"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}