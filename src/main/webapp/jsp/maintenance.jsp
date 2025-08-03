<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ptfms.final_project.model.MaintenanceLog" %>
<!DOCTYPE html>
<html>
<head>
    <title>PTFMS - Maintenance</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="nav">
        <a href="jsp/dashboard.jsp">← Back to Dashboard</a>
    </div>
    
    <h1>Maintenance Management</h1>
    
    <!-- Add Maintenance Log Form -->
    <h2>Add Maintenance Log</h2>
    <form method="post" action="maintenance">
        <div class="form-group">
            <label>Vehicle ID:</label><br>
            <input type="number" name="vehicleId" placeholder="e.g., 1" required>
        </div>
        
        <div class="form-group">
            <label>Part Name:</label><br>
            <input type="text" name="partName" placeholder="e.g., Brakes" required>
        </div>
        
        <div class="form-group">
            <label>Status:</label><br>
            <select name="status" required>
                <option value="">Select Status</option>
                <option value="Scheduled">Scheduled</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
                <option value="Overdue">Overdue</option>
            </select>
        </div>
        
        <div class="form-group">
            <label>Date:</label><br>
            <input type="date" name="date" required>
        </div>
        
        <button type="submit">Add Maintenance Log</button>
    </form>
    
    <hr>
    
    <!-- Maintenance Logs List -->
    <h2>Maintenance Logs</h2>
    <%
        List<MaintenanceLog> maintenanceList = (List<MaintenanceLog>) request.getAttribute("maintenanceList");
        if (maintenanceList != null && !maintenanceList.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Vehicle ID</th>
            <th>Part Name</th>
            <th>Status</th>
            <th>Date</th>
        </tr>
        <%
            for (MaintenanceLog log : maintenanceList) {
                String statusClass = "status-" + log.getStatus().toLowerCase().replace(" ", "-");
        %>
        <tr class="<%= statusClass %>">
            <td><%= log.getVehicleId() %></td>
            <td><%= log.getPartName() %></td>
            <td><%= log.getStatus() %></td>
            <td><%= log.getDate() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p>No maintenance logs found. Add some logs above.</p>
    <%
        }
    %>
</body>
</html>