package com.library.main;

import com.library.User.User;
import com.library.UserDAO.UserDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System \n");
            System.out.println("1. Add User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User newUser = new User(0, name, email, password); // ID will be auto-generated
                    if (userDAO.addUser(newUser)) {
                        System.out.println("User added successfully.");
                    } else {
                        System.out.println("Failed to add user.");
                    }
                    break;

                case 2:
                    System.out.print("Enter user ID: ");
                    int id = scanner.nextInt();
                    User user = userDAO.getUserById(id);
                    if (user != null) {
                        System.out.println("User details: " + user);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    System.out.print("Enter new name: ");
                    String updatedName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String updatedEmail = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String updatedPassword = scanner.nextLine();

                    User updatedUser = new User(updateId, updatedName, updatedEmail, updatedPassword);
                    if (userDAO.updateUser(updatedUser)) {
                        System.out.println("User updated successfully.");
                    } else {
                        System.out.println("Failed to update user.");
                    }
                    break;

                case 4:
                    System.out.print("Enter user ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (userDAO.deleteUser(deleteId)) {
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("Failed to delete user.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
