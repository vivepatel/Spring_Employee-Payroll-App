package com.Employee.Payroll.App.Employee.Payroll.App.mapper;

import com.Employee.Payroll.App.Employee.Payroll.App.dto.EmployeeDTO;
import com.Employee.Payroll.App.Employee.Payroll.App.model.Employee;

public class EmployeeMapper {

    // Convert Employee to EmployeeDTO
    EmployeeDTO obj = new EmployeeDTO( "Vivek",50000);

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Convert EmployeeDTO to Employee
    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        return employee;
    }
}