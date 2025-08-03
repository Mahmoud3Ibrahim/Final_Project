<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>PTFMS - Login</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <h1>PTFMS Login</h1>

    <%
        String error = request.getParameter("error");
        String message = request.getParameter("message");
        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <%
        } else if (message != null) {
    %>
        <p class="message"><%= message %></p>
    <%
        }
    %>

    <!-- Login Form -->
    <h2>Login</h2>
    <form method="post" action="../login">
        <input type="hidden" name="action" value="login">

        <div class="form-group">
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </div>

        <div class="form-group">
            <label>Password:</label><br>
            <input type="password" name="password" required>
        </div>

        <button type="submit">Login</button>
    </form>

    <hr>

    <!-- Register Form -->
    <h2>Register</h2>
    <form method="post" action="../login">
        <input type="hidden" name="action" value="register">

        <div class="form-group">
            <label>Name:</label><br>
            <input type="text" name="name" required>
        </div>

        <div class="form-group">
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </div>

        <div class="form-group">
            <label>Password:</label><br>
            <input type="password" name="password" required>
        </div>

        <div class="form-group">
            <label>Role:</label><br>
            <select name="role" required>
                <option value="Manager">Manager</option>
                <option value="Operator">Operator</option>
            </select>
        </div>

        <button type="submit">Register</button>
    </form>
</body>
</html>
