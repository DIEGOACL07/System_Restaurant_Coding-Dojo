document.getElementById("login-form").addEventListener("submit", function(event) {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    if (!email || !password) {
        event.preventDefault();
        document.getElementById("error-message").style.display = "block";
    }
});