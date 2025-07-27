<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ptfms.final_project.model.Vehicle" %>

<!DOCTYPE html>
<html>
<head>
   
    <title>PTFMS - Vehicles</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    
    
    <div class="nav">
        <a href="jsp/dashboard.jsp">← Back to Dashboard</a>
    </div>
    
    <h1>Vehicle Management</h1>
    
    <!-- Add Vehicle Form -->
    <h2>Add New Vehicle</h2>
    <form method="post" action="vehicles">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label>Vehicle Number:</label><br>
            <input type="text" name="vehicleNumber" placeholder="e.g., BUS007" required>
        </div>
        
        <div class="form-group">
            <label>Vehicle Type:</label><br>
            <select name="vehicleType" required>
                <option value="">Select Type</option>
                <option value="Bus">Bus</option>
                <option value="Train">Train</option>
                <option value="Rail">Rail</option>
            </select>
        </div>
        
        <button type="submit">Add Vehicle</button>
    </form>
    
    <hr>
    
    <!-- Vehicle List -->
    <h2>Vehicle List</h2>
    <%
        List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
        if (vehicles != null && !vehicles.isEmpty()) {
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Vehicle Number</th>
            <th>Vehicle Type</th>
            <th>Action</th>
        </tr>
        <% for (Vehicle vehicle : vehicles) { %>
        <tr>
            <td><%= vehicle.getVehicleId() %></td>
            <td><%= vehicle.getVehicleNumber() %></td>
            <td><%= vehicle.getVehicleType() %></td>
            <td>
                <form method="post" action="vehicles" onsubmit="return confirm('Are you sure you want to delete this vehicle?');">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="vehicleId" value="<%= vehicle.getVehicleId() %>">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%  }         %>
    </table>
    <% } else {    %>
    <p>No vehicles found. Add some vehicles above.</p>
    <%  }    %>
</body>
</html>
