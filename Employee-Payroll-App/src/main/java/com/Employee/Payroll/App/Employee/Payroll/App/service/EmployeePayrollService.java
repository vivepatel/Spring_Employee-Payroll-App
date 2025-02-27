package com.Employee.Payroll.App.Employee.Payroll.App.service;

import com.Employee.Payroll.App.Employee.Payroll.App.model.Employee;
import com.Employee.Payroll.App.Employee.Payroll.App.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // In-memory storage for employees
    private List<Employee> inMemoryEmployees = new ArrayList<>();

    // Get all employees (from in-memory list)
    public List<Employee> getAllEmployees() {
        return inMemoryEmployees;
    }

    // Get employee by ID (from in-memory list)
    public Employee getEmployeeById(Long id) {
        return inMemoryEmployees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add employee (to in-memory list)
    public Employee addEmployee(Employee employee) {
        employee.setId((long) (inMemoryEmployees.size() + 1)); // Auto-generate ID
        inMemoryEmployees.add(employee);
        return employee;
    }

    // Update employee (in in-memory list)
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
        }
        return existingEmployee;
    }

    // Delete employee (from in-memory list)
    public void deleteEmployee(Long id) {
        inMemoryEmployees.removeIf(employee -> employee.getId().equals(id));
    }

    // Old functionality (interacting with the repository)
    public List<Employee> getAllEmployeesFromRepository() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByIdFromRepository(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployeeToRepository(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeInRepository(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeFromRepository(Long id) {
        employeeRepository.deleteById(id);
    }
}