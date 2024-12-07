<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&family=Lobster&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="<%= request.getContextPath() %>/script.js" defer></script>
</head>
<body>
<header>
    <h1>Library Management System</h1>
    <div class="header-buttons">
        <button onclick="toggleForm('login')">Login</button>
        <button onclick="toggleForm('signup')">Sign Up</button>
    </div>
</header>

<div class="content">
    <div class="social-box">
        <h3>Follow Us On Social Media</h3>
        <a href="https://www.linkedin.com/in/abhishek-tomar-7aa29127b/" target="_blank"><i class="fab fa-linkedin"></i> LinkedIn</a>
        <a href="https://github.com/Abhishek-09-Tomar/WEB-DEVELOPMENT-HUB" target="_blank"><i class="fab fa-github"></i> GitHub</a>
        <a href="https://www.facebook.com/share/188ESnieFm/" target="_blank"><i class="fab fa-facebook"></i> Facebook</a>
        <a href="https://www.instagram.com/abhishektomar135/profilecard/?igsh=MWl6cDNxNzZ3OGtjbw==" target="_blank"><i class="fab fa-instagram"></i> Instagram</a>
        <a href="https://x.com/AbhishekTo70974?t=CK3yGYSuIDCMMtkkjQ_CnA&s=08" target="_blank"><i class="fab fa-twitter"></i> Twitter</a>
    </div>
</div>

<div class="quote">
    "A room without books is like a body without a soul"
</div>

<footer>
    <h3>About Library Management System</h3>
    <div>
        <h4>Vision</h4>
        <p>Our vision is to empower libraries with a digital platform that enhances accessibility, promotes a culture of reading, and fosters a love of learning.</p>
    </div>
    <div>
        <h4>Contact Information</h4>
        <p>Email: info@librarysystem.com</p>
        <p>Phone: +1 (800) 123-4567</p>
    </div>

    <div class="social-footer">
        <a href="#" target="_blank"><i class="fab fa-facebook"></i></a>
        <a href="#" target="_blank"><i class="fab fa-twitter"></i></a>
        <a href="#" target="_blank"><i class="fab fa-instagram"></i></a>
    </div>
</footer>

<div class="form-container" id="loginForm">
    <button class="close-btn" onclick="closeForm('login')">×</button>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="loginUserID">UserID</label>
            <input type="text" id="loginUserID" name="userID" placeholder="Enter your UserID" required>
        </div>
        <div class="form-group">
            <label for="loginEmail">Email</label>
            <input type="email" id="loginEmail" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="loginPassword">Password</label>
            <input type="password" id="loginPassword" name="password" placeholder="Enter your password" required>
        </div>
        <button class="submit-btn" type="submit">Login</button>
    </form>
</div>

<div class="form-container" id="signupForm">
    <button class="close-btn" onclick="closeForm('signup')">×</button>
    <h2>Sign Up</h2>
    <form action="SignupServlet" method="post">
        <div class="form-group">
            <label for="signupUserID">UserID</label>
            <input type="text" id="signupUserID" name="userID" placeholder="Enter your UserID" required>
        </div>
        <div class="form-group">
            <label for="signupEmail">Email</label>
            <input type="email" id="signupEmail" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="signupPhone">Contact No</label>
            <input type="text" id="signupPhone" name="phone" placeholder="Enter your contact number" required>
        </div>
        <div class="form-group">
            <label for="signupPassword">Password</label>
            <input type="password" id="signupPassword" name="password" placeholder="Enter your password" required>
        </div>
        <button class="submit-btn" type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>
