document.addEventListener("DOMContentLoaded", function() {
    var loginButton = document.getElementById("loginButton");
    var logoutButton = document.getElementById("logoutButton");
    var messageContainer = document.getElementById("message");

    // Function to check if the user is logged in
    function isUserLoggedIn() {
        // This is a placeholder check. Replace it with actual logic.
        return false; // Replace with your actual login check
    }

    // Event listener for login button
    loginButton.addEventListener("click", function() {
        if (!isUserLoggedIn()) {
            messageContainer.innerText = "You need to log in first to access this feature.";
        } else if (!document.getElementById('loginForm').elements['username'].value || !document.getElementById('loginForm').elements['password'].value) {
            // Check if the login form inputs are empty
            alert("Please fill in both the username and password.");
        } else {
            toggleForm('login'); // Call to toggle login form
        }
    });

    // Event listener for logout button
    logoutButton.addEventListener("click", function() {
        if (!isUserLoggedIn()) {
            messageContainer.innerText = "You are not logged in. Please log in first.";
        } else {
            closeForm('login'); // Call to close login form
        }
    });

    // Function to toggle login and signup forms
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

    // Function to close forms
    function closeForm(formType) {
        if (formType === 'login') {
            document.getElementById('loginForm').classList.remove('show');
        } else if (formType === 'signup') {
            document.getElementById('signupForm').classList.remove('show');
        }
    }

    // Function to submit forms
    function submitForm(formType) {
        if (!isUserLoggedIn()) {
            messageContainer.innerText = "You need to log in first to submit the form.";
        } else {
            var loginForm = document.getElementById('loginForm');
            if (!loginForm.elements['username'].value || !loginForm.elements['password'].value) {
                // Check if the login form inputs are empty
                alert("Please fill in both the username and password.");
            } else {
                alert(formType.charAt(0).toUpperCase() + formType.slice(1) + ' form submitted!');
            }
        }
    }
});
