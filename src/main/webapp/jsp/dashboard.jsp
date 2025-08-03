<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("userEmail");
    String role = (String) session.getAttribute("userRole");

    if (role == null || username == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="container">
    <h1><%= role %> Dashboard</h1>
    <div class="welcome">
        Welcome, <strong><%= username %></strong>! (Role: <%= role %>)
    </div>

    <div class="menu">
        <h3>Main Menu</h3>

        <% if ("Manager".equals(role)) { %>
            <a href="<%= request.getContextPath() %>/vehicles">Manage Vehicles</a>
            <a href="<%= request.getContextPath() %>/fuel">Fuel Usage</a>
            <a href="<%= request.getContextPath() %>/maintenance">Maintenance</a>
            <a href="<%= request.getContextPath() %>/gps">GPS Tracking</a>
            <a href="<%= request.getContextPath() %>/jsp/reports.jsp">Reports</a>
        <% } else if ("Operator".equals(role)) { %>
            <a href="<%= request.getContextPath() %>/gps">Log GPS / Break Times</a>
            <a href="<%= request.getContextPath() %>/reports">View My Performance</a>
        <% } %>

        <a href="<%= request.getContextPath() %>/jsp/login.jsp">Logout</a>
    </div>

    <div class="info-box">
        <% if ("Manager".equals(role)) { %>
            <p>Use the buttons above to manage vehicles, monitor fuel, schedule maintenance, and view reports.</p>
        <% } else { %>
            <p>You can log your route activity and view your on-time performance and other metrics.</p>
        <% } %>
    </div>
</div>
</body>
</html>
