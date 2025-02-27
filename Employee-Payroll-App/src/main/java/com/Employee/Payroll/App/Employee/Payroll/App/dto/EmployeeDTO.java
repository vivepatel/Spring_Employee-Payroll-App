package com.Employee.Payroll.App.Employee.Payroll.App.dto;

public class EmployeeDTO {
    private String name;
    private double salary;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}