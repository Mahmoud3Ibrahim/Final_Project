package com.ptfms.final_project.model;

/**
 * Report Model Class - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class Report {
    
    private int reportId;
    private String reportType;
    private String reportTitle;
    private String reportData;
    
    /**
     * Default constructor
     */
    public Report() {
    }
    
    /**
     * Constructor with parameters
     * @param reportType report type
     * @param reportTitle report title
     * @param reportData report data
     */
    public Report(String reportType, String reportTitle, String reportData) {
        this.reportType = reportType;
        this.reportTitle = reportTitle;
        this.reportData = reportData;
    }
    
    /**
     * Get report ID
     * @return report ID
     */
    public int getReportId() {
        return reportId;
    }
    
    /**
     * Set report ID
     * @param reportId report ID
     */
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
    
    /**
     * Get report type
     * @return report type
     */
    public String getReportType() {
        return reportType;
    }
    
    /**
     * Set report type
     * @param reportType report type
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    
    /**
     * Get report title
     * @return report title
     */
    public String getReportTitle() {
        return reportTitle;
    }
    
    /**
     * Set report title
     * @param reportTitle report title
     */
    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }
    
    /**
     * Get report data
     * @return report data
     */
    public String getReportData() {
        return reportData;
    }
    
    /**
     * Set report data
     * @param reportData report data
     */
    public void setReportData(String reportData) {
        this.reportData = reportData;
    }
    
    /**
     * Convert to string
     * @return string representation
     */
    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportType='" + reportType + '\'' +
                ", reportTitle='" + reportTitle + '\'' +
                '}';
    }
}