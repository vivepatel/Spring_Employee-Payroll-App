package com.Employee.Payroll.App.Employee.Payroll.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class EmployeeDTO {
    private String name;
    private double salary;
    public EmployeeDTO(String name,double salary)
    {
        this.salary=salary;
        this.name=name;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}




<<<<<<< HEAD
    }





=======
>>>>>>> UC6
