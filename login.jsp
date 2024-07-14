<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="Stylesheet" href="login.css">
</head>
<body>
<h1>You Successfully Registered</h1>
<h2>Login Form</h2>
    <form action="LoginServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <br>
    <form action="register.jsp" method="get">
    <input type="submit" value="Register">
</form>
</body>
</html>