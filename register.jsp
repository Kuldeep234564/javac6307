<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration.com</title>
<link rel="Stylesheet" href="register.css">
</head>
<body>

<div class="container">
    <div class="form-container">
        <h2>Register</h2>
        <form action="BSCCS" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            
            <label for="confirm-password">Confirm Password</label>
            <input type="password" id="confirm-password" name="confirm-password" required>
            
            <button type="submit">Sign Up</button>
        </form>
        <p>Have an Account? <a href="login.jsp">Login Here</a></p>
    </div>
</div>
</body>
</html>
