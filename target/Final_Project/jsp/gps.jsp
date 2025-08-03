<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ptfms.final_project.model.Location" %>
<!DOCTYPE html>
<html>
<head>
    <title>PTFMS - GPS Tracking</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="nav">
        <a href="dashboard.jsp">← Back to Dashboard</a>
    </div>
    
    <h1>GPS Tracking</h1>
    
    <!-- Manual GPS Location Form -->
    <h2>Add GPS Location (Manual Entry)</h2>
    <form method="post" action="gps">
        <input type="hidden" name="action" value="manual">
        
        <div class="form-group">
            <label>Vehicle ID:</label><br>
            <input type="number" name="vehicleId" placeholder="e.g., 1" required>
        </div>
        
        <div class="form-group">
            <label>Station Name:</label><br>
            <input type="text" name="stationName" placeholder="e.g., Downtown Station" required>
        </div>
        
        <div class="form-group">
            <label>Timestamp:</label><br>
            <input type="datetime-local" name="timestamp" required>
        </div>
        
        <button type="submit">Add Manual Location</button>
    </form>
    
    <hr>
    
    <!-- External GPS Sync Form (Adapter Pattern) -->
    <h2>Sync from External GPS (Adapter Pattern)</h2>
    <form method="post" action="gps">
        <input type="hidden" name="action" value="sync_external">
        
        <div class="form-group">
            <label>Vehicle ID:</label><br>
            <input type="number" name="vehicleId" placeholder="e.g., 1" required>
        </div>
        
        <button type="submit" style="background-color: #007bff;">️ Sync from External GPS</button>
        <p><small>This will automatically get the current location from external GPS system using Adapter Pattern</small></p>
    </form>
    
    <hr>
    
    <!-- GPS Locations List -->
    <h2>Vehicle Locations</h2>
    <%
        List<Location> locationList = (List<Location>) request.getAttribute("locationList");
        if (locationList != null && !locationList.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Vehicle ID</th>
            <th>Station Name</th>
            <th>Timestamp</th>
            <th>Source</th>
        </tr>
        <%
            for (Location location : locationList) {
                // Determine if it's from external GPS based on station name pattern
                String source = (location.getStationName().contains("Transit Center") || 
                               location.getStationName().contains("University Campus") ||
                               location.getStationName().contains("Shopping Mall") ||
                               location.getStationName().contains("Airport Terminal") ||
                               location.getStationName().contains("City Hall") ||
                               location.getStationName().contains("Hospital District") ||
                               location.getStationName().contains("Sports Complex") ||
                               location.getStationName().contains("Business District") ||
                               location.getStationName().contains("Subway Station") ||
                               location.getStationName().contains("Metro Stop")) ? "External GPS" : "Manual Entry";
                String rowClass = source.equals("External GPS") ? "style='background-color: #e3f2fd;'" : "";
        %>
        <tr <%= rowClass %>>
            <td><%= location.getVehicleId() %></td>
            <td><%= location.getStationName() %></td>
            <td><%= location.getTimestamp() %></td>
            <td><%= source %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p>No GPS locations found. Add some locations above.</p>
    <%
        }
    %>
    
    <!-- Instructions -->
    <div class="info-box">
        <h3>Instructions:</h3>
        <p><strong>Manual Entry:</strong> Enter location details manually</p>
        <p><strong>External GPS Sync:</strong> Automatically gets location from external GPS system using Adapter Pattern</p>
        <p><em>External GPS entries are highlighted in blue and show "Station" + Vehicle ID format</em></p>
    </div>
</body>
</html>