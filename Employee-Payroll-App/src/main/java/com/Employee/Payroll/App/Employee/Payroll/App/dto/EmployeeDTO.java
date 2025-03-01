package com.Employee.Payroll.App.Employee.Payroll.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;






@Slf4j
// Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
public class EmployeeDTO {
    private String name;
    private double salary;
    public EmployeeDTO(String name, double salary)
    {
        this.name=name;
        this.salary=salary;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "EmployeeDTO{" + "name='" + name + '\'' + ", Salary=" + salary + '}';

    }
}






