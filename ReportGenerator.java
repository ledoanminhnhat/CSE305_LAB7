package com.mycompany.cse305_lab5;

import java.util.List;

class Property {
    private final String name;
    private final double rentAmount;

    public Property(String name, double rentAmount) {
        this.name = name;
        this.rentAmount = rentAmount;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }
}

class FinancialReport {
    private final String reportTitle;
    private final List<Property> properties;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    private double calculateTotalRent() {
        return properties.stream().mapToDouble(Property::getRentAmount).sum();
    }

    public void generateReport() {
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");

        properties.forEach(property -> ReportPrinter.printPropertyDetails(property));
        
        double totalRent = calculateTotalRent();
        System.out.println("Total Rent Amount: $" + totalRent);
    }
}

class Report {
    private String title;
    private String description;

    private Report() {}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String title;
        private String description;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Report build() {
            Report report = new Report();
            report.title = this.title;
            report.description = this.description;
            return report;
        }
    }
}

class ReportPrinter {
    public static void printPropertyDetails(Property property) {
        System.out.println("Property: " + property.getName());
        System.out.println("Rent Amount: $" + property.getRentAmount());
        System.out.println("--------------------");
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Property property1 = new Property("Apartment A", 1500.0);
        Property property2 = new Property("House B", 2000.0);
        Property property3 = new Property("Condo C", 1800.0);

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", List.of(property1, property2, property3));
        financialReport.generateReport();

        Report report = new Report.Builder()
            .setTitle("Quarterly Report")
            .setDescription("This report provides a summary of the financial performance over the last quarter.")
            .build();
        
        System.out.println("Report Title: " + report.getTitle());
        System.out.println("Report Description: " + report.getDescription());
    }
}
