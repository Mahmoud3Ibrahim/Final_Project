<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>PTFMS - Reports</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <%
        // Get real data from servlet
        Integer totalVehicles = (Integer) request.getAttribute("totalVehicles");
        Integer totalFuelRecords = (Integer) request.getAttribute("totalFuelRecords");
        Integer totalGPSLocations = (Integer) request.getAttribute("totalGPSLocations");
        Integer totalMaintenanceLogs = (Integer) request.getAttribute("totalMaintenanceLogs");
        
        Integer busCount = (Integer) request.getAttribute("busCount");
        Integer trainCount = (Integer) request.getAttribute("trainCount");
        Integer railCount = (Integer) request.getAttribute("railCount");
        
        Double totalFuelConsumption = (Double) request.getAttribute("totalFuelConsumption");
        
        Integer scheduledCount = (Integer) request.getAttribute("scheduledCount");
        Integer completedCount = (Integer) request.getAttribute("completedCount");
        Integer overdueCount = (Integer) request.getAttribute("overdueCount");
        Integer inProgressCount = (Integer) request.getAttribute("inProgressCount");
        
        // Set defaults if null
        if (totalVehicles == null) totalVehicles = 0;
        if (totalFuelRecords == null) totalFuelRecords = 0;
        if (totalGPSLocations == null) totalGPSLocations = 0;
        if (totalMaintenanceLogs == null) totalMaintenanceLogs = 0;
        if (busCount == null) busCount = 0;
        if (trainCount == null) trainCount = 0;
        if (railCount == null) railCount = 0;
        if (totalFuelConsumption == null) totalFuelConsumption = 0.0;
        if (scheduledCount == null) scheduledCount = 0;
        if (completedCount == null) completedCount = 0;
        if (overdueCount == null) overdueCount = 0;
        if (inProgressCount == null) inProgressCount = 0;
    %>
    
    <div class="nav">
        <a href="jsp/dashboard.jsp">← Back to Dashboard</a>
    </div>
    
    <h1>System Reports</h1>
    
    <!-- Quick Statistics -->
    <div class="stats-row">
        <div class="stat-box">
            <div class="stat-number"><%= totalVehicles %></div>
            <div>Total Vehicles</div>
        </div>
        <div class="stat-box">
            <div class="stat-number"><%= totalFuelRecords %></div>
            <div>Fuel Records</div>
        </div>
        <div class="stat-box">
            <div class="stat-number"><%= totalGPSLocations %></div>
            <div>GPS Locations</div>
        </div>
        <div class="stat-box">
            <div class="stat-number"><%= totalMaintenanceLogs %></div>
            <div>Maintenance Logs</div>
        </div>
    </div>
    
    <!-- Vehicle Report -->
    <div class="report-section">
        <h2>Vehicle Fleet Summary</h2>
        <table>
            <tr>
                <th>Vehicle Type</th>
                <th>Count</th>
                <th>Percentage</th>
            </tr>
            <tr>
                <td>Buses</td>
                <td><%= busCount %></td>
                <td><%= totalVehicles > 0 ? Math.round((busCount * 100.0) / totalVehicles) : 0 %>%</td>
            </tr>
            <tr>
                <td>Trains</td>
                <td><%= trainCount %></td>
                <td><%= totalVehicles > 0 ? Math.round((trainCount * 100.0) / totalVehicles) : 0 %>%</td>
            </tr>
            <tr>
                <td>Rails</td>
                <td><%= railCount %></td>
                <td><%= totalVehicles > 0 ? Math.round((railCount * 100.0) / totalVehicles) : 0 %>%</td>
            </tr>
            <tr>
                <th>Total</th>
                <th><%= totalVehicles %></th>
                <th>100%</th>
            </tr>
        </table>
    </div>
    
    <!-- Fuel Usage Report -->
    <div class="report-section">
        <h2>Fuel Usage Summary</h2>
        <table>
            <tr>
                <th>Metric</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Total Fuel Consumption</td>
                <td><%= String.format("%.2f", totalFuelConsumption) %> liters</td>
            </tr>
            <tr>
                <td>Total Records</td>
                <td><%= totalFuelRecords %></td>
            </tr>
            <tr>
                <td>Average per Record</td>
                <td><%= totalFuelRecords > 0 ? String.format("%.2f", totalFuelConsumption / totalFuelRecords) : "0.00" %> liters</td>
            </tr>
        </table>
    </div>
    
    <!-- Maintenance Report -->
    <div class="report-section">
        <h2>Maintenance Summary</h2>
        <table>
            <tr>
                <th>Status</th>
                <th>Count</th>
                <th>Percentage</th>
            </tr>
            <tr>
                <td>Scheduled</td>
                <td><%= scheduledCount %></td>
                <td><%= totalMaintenanceLogs > 0 ? Math.round((scheduledCount * 100.0) / totalMaintenanceLogs) : 0 %>%</td>
            </tr>
            <tr>
                <td>In Progress</td>
                <td><%= inProgressCount %></td>
                <td><%= totalMaintenanceLogs > 0 ? Math.round((inProgressCount * 100.0) / totalMaintenanceLogs) : 0 %>%</td>
            </tr>
            <tr>
                <td>Completed</td>
                <td><%= completedCount %></td>
                <td><%= totalMaintenanceLogs > 0 ? Math.round((completedCount * 100.0) / totalMaintenanceLogs) : 0 %>%</td>
            </tr>
            <tr>
                <td>Overdue</td>
                <td><%= overdueCount %></td>
                <td><%= totalMaintenanceLogs > 0 ? Math.round((overdueCount * 100.0) / totalMaintenanceLogs) : 0 %>%</td>
            </tr>
            <tr>
                <th>Total</th>
                <th><%= totalMaintenanceLogs %></th>
                <th>100%</th>
            </tr>
        </table>
    </div>
    
    <!-- GPS Tracking Report -->
    <div class="report-section">
        <h2>GPS Tracking Summary</h2>
        <p><strong>Total Locations Tracked:</strong> <%= totalGPSLocations %></p>
        <p><strong>Tracking Status:</strong> 
            <% if (totalGPSLocations > 0) { %>
                Active - <%= totalGPSLocations %> locations recorded
            <% } else { %>
                No GPS data available
            <% } %>
        </p>
    </div>
    
    <!-- System Overview -->
    <div class="report-section">
        <h2>System Overview</h2>
        <table>
            <tr>
                <th>Component</th>
                <th>Status</th>
                <th>Records</th>
            </tr>
            <tr>
                <td>Vehicle Management</td>
                <td><%= totalVehicles > 0 ? "Active" : "No Data" %></td>
                <td><%= totalVehicles %></td>
            </tr>
            <tr>
                <td>Fuel Tracking</td>
                <td><%= totalFuelRecords > 0 ? "Active" : "No Data" %></td>
                <td><%= totalFuelRecords %></td>
            </tr>
            <tr>
                <td>GPS Tracking</td>
                <td><%= totalGPSLocations > 0 ? "Active" : "No Data" %></td>
                <td><%= totalGPSLocations %></td>
            </tr>
            <tr>
                <td>Maintenance Tracking</td>
                <td><%= totalMaintenanceLogs > 0 ? "Active" : "No Data" %></td>
                <td><%= totalMaintenanceLogs %></td>
            </tr>
        </table>
    </div>
</body>
</html>