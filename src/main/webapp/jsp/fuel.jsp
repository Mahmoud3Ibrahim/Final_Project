<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ptfms.final_project.model.FuelUsage" %>
<!DOCTYPE html>
<html>
<head>
    <title>PTFMS - Fuel Usage</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">


</head>
<body>
    <div class="nav">
        <a href="jsp/dashboard.jsp">← Back to Dashboard</a>
    </div>
    
    <h1>Fuel Usage Management</h1>
    
    <!-- Add Fuel Usage Form -->
    <h2>Add Fuel Usage</h2>
    <form method="post" action="fuel">
        <div class="form-group">
            <label>Vehicle ID:</label><br>
            <input type="number" name="vehicleId" placeholder="e.g., 1" required>
        </div>
        
        <div class="form-group">
            <label>Fuel Amount:</label><br>
            <input type="number" name="amount" step="0.01" placeholder="e.g., 45.5" required>
        </div>
        
        <div class="form-group">
            <label>Date:</label><br>
            <input type="date" name="date" required>
        </div>
        
        <button type="submit">Add Fuel Usage</button>
    </form>
    
    <hr>
    
    <!-- Fuel Usage List -->
    <h2>Fuel Usage Records</h2>
    <%
        List<FuelUsage> fuelList = (List<FuelUsage>) request.getAttribute("fuelList");
        if (fuelList != null && !fuelList.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Vehicle ID</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <%
            for (FuelUsage fuel : fuelList) {
        %>
        <tr>
            <td><%= fuel.getVehicleId() %></td>
            <td><%= fuel.getAmount() %></td>
            <td><%= fuel.getDate() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p>No fuel usage records found. Add some records above.</p>
    <%
        }
    %>
</body>
</html>