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
        loginLayout.setStyle("-fx-alignment: center; -fx-padding: 20;");

        Label titleLabel = new Label("Library Management System");
        titleLabel.setStyle("-fx-font-size: 18px;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
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

        Scene loginScene = new Scene(loginLayout, 400, 300);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private boolean validateCredentials(String username, String password) {
        return "abhishek".equals(username) && "12345".equals(password);
    }

    private void showDashboard() {
        BorderPane dashboardLayout = new BorderPane();

        // Left Navigation Pane
        VBox navMenu = new VBox(10);
        navMenu.setPadding(new Insets(10));
        navMenu.setStyle("-fx-background-color: #333; -fx-padding: 10;");

        Button manageBooksButton = new Button("Manage Books");
        manageBooksButton.setOnAction(event -> showManageBooks());

        Button manageMembersButton = new Button("Manage Members");
        manageMembersButton.setOnAction(event -> showManageMembers());

        Button issueBookButton = new Button("Issue Book");
        issueBookButton.setOnAction(event -> showIssueBook());

        Button returnBookButton = new Button("Return Book");
        returnBookButton.setOnAction(event -> showReturnBook());

        Button reportsButton = new Button("Reports & Analytics");
        reportsButton.setOnAction(event -> showReports());

        navMenu.getChildren().addAll(manageBooksButton, manageMembersButton, issueBookButton, returnBookButton, reportsButton);

        // Center Content
        VBox centerLayout = new VBox(10);
        centerLayout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Welcome To The Library Dashboard");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-padding: 20px;");

        TextField searchField = new TextField();
        searchField.setPromptText("Search by title, author, or genre...");
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> System.out.println("Searching for: " + searchField.getText()));

        HBox searchLayout = new HBox(5, searchField, searchButton);
        centerLayout.getChildren().addAll(welcomeLabel, searchLayout);

        dashboardLayout.setLeft(navMenu);
        dashboardLayout.setCenter(centerLayout);

        Scene dashboardScene = new Scene(dashboardLayout, 800, 500);
        primaryStage.setScene(dashboardScene);
        primaryStage.show();
    }

    private void showManageBooks() {
        Stage bookStage = new Stage();
        bookStage.setTitle("Manage Books");

        VBox bookLayout = new VBox(10);
        bookLayout.setPadding(new Insets(10));
        Label bookLabel = new Label("Manage Books");
        bookLabel.setStyle("-fx-font-size: 18px;");

        Button addBookButton = new Button("Add Book");
        Button editBookButton = new Button("Edit Book");
        Button deleteBookButton = new Button("Delete Book");

        bookLayout.getChildren().addAll(bookLabel, addBookButton, editBookButton, deleteBookButton);
        Scene bookScene = new Scene(bookLayout, 400, 300);
        bookStage.setScene(bookScene);
        bookStage.show();
    }

    private void showManageMembers() {
        Stage memberStage = new Stage();
        memberStage.setTitle("Manage Members");

        VBox memberLayout = new VBox(10);
        memberLayout.setPadding(new Insets(10));
        Label memberLabel = new Label("Manage Members");
        memberLabel.setStyle("-fx-font-size: 18px;");

        Button addMemberButton = new Button("Add Member");
        Button editMemberButton = new Button("Edit Member");
        Button deleteMemberButton = new Button("Delete Member");

        memberLayout.getChildren().addAll(memberLabel, addMemberButton, editMemberButton, deleteMemberButton);
        Scene memberScene = new Scene(memberLayout, 400, 300);
        memberStage.setScene(memberScene);
        memberStage.show();
    }

    private void showIssueBook() {
        Stage issueStage = new Stage();
        issueStage.setTitle("Issue Book");

        VBox issueLayout = new VBox(10);
        issueLayout.setPadding(new Insets(10));
        Label issueLabel = new Label("Issue Book");
        issueLabel.setStyle("-fx-font-size: 18px;");

        TextField bookIdField = new TextField();
        bookIdField.setPromptText("Book ID");
        TextField memberIdField = new TextField();
        memberIdField.setPromptText("Member ID");
        DatePicker issueDate = new DatePicker();
        issueDate.setPromptText("Issue Date");

        Button issueButton = new Button("Issue Book");

        issueLayout.getChildren().addAll(issueLabel, bookIdField, memberIdField, issueDate, issueButton);
        Scene issueScene = new Scene(issueLayout, 400, 300);
        issueStage.setScene(issueScene);
        issueStage.show();
    }

    private void showReturnBook() {
        Stage returnStage = new Stage();
        returnStage.setTitle("Return Book");

        VBox returnLayout = new VBox(10);
        returnLayout.setPadding(new Insets(10));
        Label returnLabel = new Label("Return Book");
        returnLabel.setStyle("-fx-font-size: 18px;");

        TextField bookIdField = new TextField();
        bookIdField.setPromptText("Book ID");
        DatePicker returnDate = new DatePicker();
        returnDate.setPromptText("Return Date");

        Button returnButton = new Button("Return Book");

        returnLayout.getChildren().addAll(returnLabel, bookIdField, returnDate, returnButton);
        Scene returnScene = new Scene(returnLayout, 400, 300);
        returnStage.setScene(returnScene);
        returnStage.show();
    }

    private void showReports() {
        Stage reportStage = new Stage();
        reportStage.setTitle("Reports & Analytics");

        VBox reportLayout = new VBox(10);
        reportLayout.setPadding(new Insets(10));
        Label reportLabel = new Label("Reports & Analytics");
        reportLabel.setStyle("-fx-font-size: 18px;");

        Button overdueBooksReportButton = new Button("View Overdue Books");
        Button popularBooksReportButton = new Button("View Popular Books");
        Button borrowingTrendsReportButton = new Button("View Borrowing Trends");

        reportLayout.getChildren().addAll(reportLabel, overdueBooksReportButton, popularBooksReportButton, borrowingTrendsReportButton);
        Scene reportScene = new Scene(reportLayout, 400, 300);
        reportStage.setScene(reportScene);
        reportStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
