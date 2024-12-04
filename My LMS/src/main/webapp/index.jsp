<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&family=Lobster&display=swap');
        @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css');

        /* General Styles */
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background: linear-gradient(45deg, #000, #0a0, #f90);
            background-size: 400% 400%;
            animation: gradientBG 10s ease infinite;
            color: #fff;
            transition: background 2s ease;
        }

        @keyframes gradientBG {
            0% {
                background-position: 0% 50%;
            }

            50% {
                background-position: 100% 50%;
            }

            100% {
                background-position: 0% 50%;
            }
        }

        /* Header */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background: rgba(0, 0, 0, 0.8);
            color: white;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.5);
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
            font-family: 'Lobster', cursive;
        }

        .header-buttons {
            display: flex;
            gap: 15px;
        }

        .header-buttons button {
            padding: 12px 25px;
            font-size: 1.1em;
            background: #00f;
            color: #0f0;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.4);
            transition: all 0.3s ease;
        }

        .header-buttons button:hover {
            transform: translateY(-2px);
            box-shadow: 0px 6px 12px rgba(0, 255, 0, 0.5);
        }

        /* Main Content */
        .content {
            display: flex;
            justify-content: center;
            padding: 20px;
        }

        /* Social Media Box */
        .social-box {
            width: 250px;
            background: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0px 4px 8px rgba(0, 255, 0, 0.4);
            text-align: center;
        }

        .social-box h3 {
            font-size: 1.5em;
            margin-bottom: 15px;
            color: #FFD700;
            font-family: 'Roboto', sans-serif;
        }

        .social-box a {
            display: block;
            margin: 10px 0;
            color: #fff;
            text-decoration: none;
            font-size: 1.2em;
            transition: all 0.3s ease;
        }

        .social-box a:hover {
            color: #FFD700;
        }

        .social-box i {
            margin-right: 10px;
        }

        /* Footer */
        footer {
            background: rgba(0, 0, 0, 0.9);
            padding: 30px 20px;
            color: #fff;
            margin-top: auto;
            text-align: center;
        }

        footer h3 {
            font-size: 2em;
            color: #FFD700;
        }

        footer div {
            margin: 20px 0;
        }

        footer div h4 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        footer div p {
            font-size: 1.1em;
            line-height: 1.6;
        }

        footer .social-footer {
            margin-top: 20px;
        }

        footer .social-footer a {
            margin: 0 15px;
            color: #fff;
            font-size: 1.3em;
            transition: all 0.3s ease;
        }

        footer .social-footer a:hover {
            color: #FFD700;
        }

        /* Form Styles */
        .form-container {
            position: fixed;
            top: 0;
            right: -400px;
            width: 400px;
            height: 100%;
            background: #000;
            padding: 30px;
            box-shadow: -4px 0px 10px rgba(0, 0, 0, 0.6);
            transition: all 0.3s ease-in-out;
        }

        .form-container.show {
            right: 0;
        }

        .form-container h2 {
            color: #fff;
            font-family: 'Lobster', cursive;
            font-size: 2em;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 1.1em;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 1.1em;
            border: 1px solid #fff;
            border-radius: 5px;
            background: #333;
            color: #fff;
        }

        .submit-btn {
            width: 100%;
            padding: 15px;
            font-size: 1.2em;
            background: #00f;
            color: #0f0;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.4);
            transition: all 0.3s ease;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0px 6px 12px rgba(0, 255, 0, 0.5);
        }

        .close-btn {
            position: absolute;
            top: 10px;
            left: 10px;
            color: #fff;
            font-size: 2em;
            background: none;
            border: none;
            cursor: pointer;
            transition: transform 0.3s ease;
        }

        .close-btn:hover {
            color: #f90;
            transform: rotate(90deg);
        }

        .quote {
            font-size: 4em;
            font-family: 'Lobster', cursive;
            color: #FFD700;
            padding: 20px;
            text-align: center;
            margin-top: 50px;
        }
    </style>
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
            <a href="https://www.linkedin.com/in/abhishek-tomar-7aa29127b/" target="_blank"><i
                    class="fab fa-linkedin"></i> LinkedIn</a>
            <a href="https://github.com/Abhishek-09-Tomar/WEB-DEVELOPMENT-HUB" target="_blank"><i
                    class="fab fa-github"></i> GitHub</a>
            <a href="https://www.facebook.com/share/188ESnieFm/" target="_blank"><i class="fab fa-facebook"></i>
                Facebook</a>
            <a href="https://www.instagram.com/abhishektomar135/profilecard/?igsh=MWl6cDNxNzZ3OGtjbw=="
                target="_blank"><i class="fab fa-instagram"></i> Instagram</a>
            <a href="https://x.com/AbhishekTo70974?t=CK3yGYSuIDCMMtkkjQ_CnA&s=08" target="_blank"><i
                    class="fab fa-twitter"></i> Twitter</a>
        </div>
    </div>

    <div class="quote">
        "A room without books is like a body without a soul"
    </div>

    <footer>
        <h3>About Library Management System</h3>
        <div>
            <h4>Vision</h4>
            <p>Our vision is to empower libraries with a digital platform that enhances accessibility, promotes a
                culture of reading, and fosters a love of learning.</p>
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

    <!-- Login Form -->
    <div class="form-container" id="loginForm">
        <button class="close-btn" onclick="closeForm('login')">×</button>
        <h2>Login</h2>
        <div class="form-group">
            <label for="loginUserID">UserID</label>
            <input type="text" id="loginUserID" placeholder="Enter your UserID">
        </div>
        <div class="form-group">
            <label for="loginEmail">Email</label>
            <input type="email" id="loginEmail" placeholder="Enter your email">
        </div>
        <div class="form-group">
            <label for="loginPassword">Password</label>
            <input type="password" id="loginPassword" placeholder="Enter your password">
        </div>
        <button class="submit-btn" onclick="submitForm('login')">Login</button>
    </div>

    <!-- Sign Up Form -->
    <div class="form-container" id="signupForm">
        <button class="close-btn" onclick="closeForm('signup')">×</button>
        <h2>Sign Up</h2>
        <div class="form-group">
            <label for="signupUserID">UserID</label>
            <input type="text" id="signupUserID" placeholder="Enter your UserID">
        </div>
        <div class="form-group">
            <label for="signupEmail">Email</label>
            <input type="email" id="signupEmail" placeholder="Enter your email">
        </div>
        <div class="form-group">
            <label for="signupPhone">Contact No</label>
            <input type="text" id="signupPhone" placeholder="Enter your contact number">
        </div>
        <div class="form-group">
            <label for="signupPassword">Password</label>
            <input type="password" id="signupPassword" placeholder="Enter your password">
        </div>
        <button class="submit-btn" onclick="submitForm('signup')">Sign Up</button>
    </div>


    <!-- add dashboard -->


    <script>
        function toggleForm(formType) {
            const loginForm = document.getElementById('loginForm');
            const signupForm = document.getElementById('signupForm');
            if (formType === 'login') {
                loginForm.classList.toggle('show');
                signupForm.classList.remove('show');
            } else if (formType === 'signup') {
                signupForm.classList.toggle('show');
                loginForm.classList.remove('show');
            }
        }

        function closeForm(formType) {
            if (formType === 'login') {
                document.getElementById('loginForm').classList.remove('show');
            } else if (formType === 'signup') {
                document.getElementById('signupForm').classList.remove('show');
            }
        }

        function submitForm(formType) {
            alert(formType.charAt(0).toUpperCase() + formType.slice(1) + ' form submitted!');
        }
    </script>
</body>

</html>