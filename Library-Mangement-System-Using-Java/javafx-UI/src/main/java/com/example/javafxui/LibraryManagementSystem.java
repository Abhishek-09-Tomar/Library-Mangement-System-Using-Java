package com.example.javafxui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LibraryManagementSystem extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Library Management System");

        // Show the login screen initially
        showLoginScreen();
    }

    private void showLoginScreen() {
        VBox loginLayout = new VBox(10);
        loginLayout.setStyle("-fx-alignment: center; -fx-padding: 500;");

        Label titleLabel = new Label("Library Management System");
        titleLabel.setStyle("-fx-font-size: 42px;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-text-fill: #FFD700; -fx-background-color: #FF6347;");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (validateCredentials(username, password)) {
                showDashboard();
            } else {
                showAlert("Login Failed", "Invalid username or password");
            }
        });

        loginLayout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);

        Scene loginScene = new Scene(loginLayout, 600, 400);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private boolean validateCredentials(String username, String password) {
        // Updated credentials
        return "abhishek".equals(username) && "12345".equals(password);
    }

    private void showDashboard() {
        BorderPane dashboardLayout = new BorderPane();

        // Left Navigation Pane
        VBox navMenu = new VBox(10);
        navMenu.setPadding(new Insets(10));
        navMenu.setStyle("-fx-background-color: #333; -fx-padding: 10;");

        Button manageBooksButton = new Button("Manage Books");
        manageBooksButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        manageBooksButton.setOnAction(event -> showManageBooks());

        Button manageMembersButton = new Button("Manage Members");
        manageMembersButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        manageMembersButton.setOnAction(event -> showManageMembers());

        Button issueBookButton = new Button("Issue Book");
        issueBookButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        issueBookButton.setOnAction(event -> showIssueBook());

        Button returnBookButton = new Button("Return Book");
        returnBookButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        returnBookButton.setOnAction(event -> showReturnBook());

        Button reportsButton = new Button("Reports & Analytics");
        reportsButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        reportsButton.setOnAction(event -> showReports());

        navMenu.getChildren().addAll(manageBooksButton, manageMembersButton, issueBookButton, returnBookButton, reportsButton);

        // Center Content: Welcome Label and Search
        VBox centerLayout = new VBox(10);
        centerLayout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Welcome To The Library Dashboard");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-padding: 20px;");

        TextField searchField = new TextField();
        searchField.setPromptText("Search by title, author, or genre...");
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        searchButton.setOnAction(event -> System.out.println("Searching for: " + searchField.getText()));

        HBox searchLayout = new HBox(5, searchField, searchButton);
        searchLayout.setPadding(new Insets(10));

        centerLayout.getChildren().addAll(welcomeLabel, searchLayout);

        // Right Pane for Notifications and Alerts
        VBox notifications = new VBox(10);
        notifications.setPadding(new Insets(10));
        notifications.setStyle("-fx-background-color: #eee; -fx-padding: 10;");
        Label notificationLabel = new Label("Notifications & Alerts");
        notificationLabel.setStyle("-fx-font-weight: bold;");

        Label overdueBooksNotification = new Label("Overdue Books: 5");
        Label lowInventoryNotification = new Label("Low Inventory on Popular Books");

        notifications.getChildren().addAll(notificationLabel, overdueBooksNotification, lowInventoryNotification);

        // Arrange components on Dashboard
        dashboardLayout.setLeft(navMenu);
        dashboardLayout.setCenter(centerLayout);
        dashboardLayout.setRight(notifications);

        Scene dashboardScene = new Scene(dashboardLayout, 800, 500);
        primaryStage.setScene(dashboardScene);
        primaryStage.show();
    }

    // Placeholder for each section
    private void showManageBooks() {
        System.out.println("Navigating to Manage Books");
    }

    private void showManageMembers() {
        System.out.println("Navigating to Manage Members");
    }

    private void showIssueBook() {
        System.out.println("Navigating to Issue Book");
    }

    private void showReturnBook() {
        System.out.println("Navigating to Return Book");
    }

    private void showReports() {
        System.out.println("Navigating to Reports & Analytics");
        VBox reportsLayout = new VBox(10);
        reportsLayout.setPadding(new Insets(10));

        Label reportsLabel = new Label("Reports & Analytics");
        reportsLabel.setStyle("-fx-font-size: 18px;");

        Button overdueBooksReportButton = new Button("View Overdue Books");
        overdueBooksReportButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        overdueBooksReportButton.setOnAction(event -> System.out.println("Generating Overdue Books Report..."));

        Button popularBooksReportButton = new Button("View Popular Books");
        popularBooksReportButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        popularBooksReportButton.setOnAction(event -> System.out.println("Generating Popular Books Report..."));

        Button borrowingTrendsReportButton = new Button("View Borrowing Trends");
        borrowingTrendsReportButton.setStyle("-fx-text-fill: red; -fx-background-color: #FF69B4;");
        borrowingTrendsReportButton.setOnAction(event -> System.out.println("Generating Borrowing Trends Report..."));

        reportsLayout.getChildren().addAll(reportsLabel, overdueBooksReportButton, popularBooksReportButton, borrowingTrendsReportButton);

        Scene reportsScene = new Scene(reportsLayout, 400, 300);
        primaryStage.setScene(reportsScene);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
