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
