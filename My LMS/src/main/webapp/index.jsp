<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <style>
        /* Basic CSS for styling */
        * { margin: 0; padding: 0; box-sizing: border-box; }
        html, body { height: 100%; font-family: Arial, sans-serif; background-color: #f4f4f9; display: flex; flex-direction: column; }
        body { display: flex; flex-direction: column; }
        header { background-color: #333; color: #fff; padding: 10px 0; text-align: center; }
        h1 { margin: 0; }
        main { flex: 1; padding: 20px; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #4CAF50; color: white; }
        form { margin: 20px 0; }
        label { margin-right: 10px; }
        button { background-color: #4CAF50; color: white; padding: 5px 15px; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
        footer { background-color: #333; color: #fff; text-align: center; padding: 10px; margin-top: auto; }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Library Management System</h1>
    </header>
    <main>
        <!-- Available Books Section -->
        <h2>Available Books</h2>
        <table>
            <tr>
                <th>Book ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Genre</th>
                <th>Availability</th>
            </tr>
            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "password");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT b.book_id, b.title, a.name AS author, p.name AS publisher, b.genre, b.available_copies FROM Books b JOIN Authors a ON b.author_id = a.author_id JOIN Publishers p ON b.publisher_id = p.publisher_id");

                    while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("book_id") %></td>
                <td><%= rs.getString("title") %></td>
                <td><%= rs.getString("author") %></td>
                <td><%= rs.getString("publisher") %></td>
                <td><%= rs.getString("genre") %></td>
                <td><%= rs.getInt("available_copies") > 0 ? "Available" : "Not Available" %></td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                }
            %>
        </table>

        <!-- Borrow a Book Section -->
        <h2>Borrow a Book</h2>
        <form action="BorrowServlet" method="post" onsubmit="return confirmAction('Are you sure you want to borrow this book?');">
            <label for="bookId">Enter Book ID:</label>
            <input type="text" id="bookId" name="bookId" required>
            <button type="submit">Borrow Book</button>
        </form>

        <!-- Categories Section -->
        <h2>Categories</h2>
        <table>
            <tr>
                <th>Category Name</th>
                <th>Description</th>
            </tr>
            <%
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT name, description FROM Categories");

                    while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("description") %></td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                }
            %>
        </table>

        <!-- Reservations Section -->
        <h2>Reserve a Book</h2>
        <form action="ReserveServlet" method="post" onsubmit="return confirmAction('Are you sure you want to reserve this book?');">
            <label for="bookIdReserve">Enter Book ID:</label>
            <input type="text" id="bookIdReserve" name="bookIdReserve" required>
            <button type="submit">Reserve Book</button>
        </form>

        <!-- Fine Payment Section -->
        <h2>Check and Pay Fines</h2>
        <form action="FinePaymentServlet" method="post">
            <label for="memberId">Enter Member ID:</label>
            <input type="text" id="memberId" name="memberId" required>
            <button type="submit">Check Fines</button>
        </form>

    </main>
    <footer>
        <p>&copy; 2024 Library Management System</p>
    </footer>

    <script>
        // JavaScript function to confirm the action
        function confirmAction(message) {
            return confirm(message);
        }
    </script>
</body>
</html>
