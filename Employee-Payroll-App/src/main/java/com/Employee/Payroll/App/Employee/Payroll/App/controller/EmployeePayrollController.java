package com.Employee.Payroll.App.Employee.Payroll.App.controller;

import com.Employee.Payroll.App.Employee.Payroll.App.dto.EmployeeDTO;
import com.Employee.Payroll.App.Employee.Payroll.App.model.Employee;
import com.Employee.Payroll.App.Employee.Payroll.App.service.EmployeePayrollService;
import com.Employee.Payroll.App.Employee.Payroll.App.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    // In-memory endpoints
    @GetMapping("/memory")
    public List<Employee> getAllEmployeesFromMemory() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/memory/{id}")
    public Employee getEmployeeByIdFromMemory(@PathVariable Long id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @PostMapping("/memory")
    public Employee addEmployeeToMemory(@RequestBody Employee employee) {
        return employeePayrollService.addEmployee(employee);
    }

    @PutMapping("/memory/{id}")
    public Employee updateEmployeeInMemory(@PathVariable Long id, @RequestBody Employee employee) {
        return employeePayrollService.updateEmployee(id, employee);
    }

    @DeleteMapping("/memory/{id}")
    public void deleteEmployeeFromMemory(@PathVariable Long id) {
        employeePayrollService.deleteEmployee(id);
    }

    // Repository endpoints
    @GetMapping
    public List<Employee> getAllEmployeesFromRepository() {
        return employeePayrollService.getAllEmployeesFromRepository();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByIdFromRepository(@PathVariable Long id) {
        return employeePayrollService.getEmployeeByIdFromRepository(id);
    }

    @PostMapping
    public Employee addEmployeeToRepository(@RequestBody Employee employee) {
        return employeePayrollService.addEmployeeToRepository(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeInRepository(@PathVariable Long id, @RequestBody Employee employee) {
        return employeePayrollService.updateEmployeeInRepository(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeFromRepository(@PathVariable Long id) {
        employeePayrollService.deleteEmployeeFromRepository(id);
    }

    // DTO endpoints
    @GetMapping("/dto")
    public List<EmployeeDTO> getAllEmployeesDTO() {
        List<Employee> employees = employeePayrollService.getAllEmployeesFromRepository();
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/dto/{id}")
    public EmployeeDTO getEmployeeDTOById(@PathVariable Long id) {
        Employee employee = employeePayrollService.getEmployeeByIdFromRepository(id);
        return EmployeeMapper.toDTO(employee);
    }
    // No-arg constructor
    EmployeeDTO dto2 = new EmployeeDTO("John", 5000.0); // Parameterized constructor


    @PostMapping("/dto")
    public EmployeeDTO addEmployeeDTO(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeePayrollService.addEmployeeToRepository(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }

    @PutMapping("/dto/{id}")
    public EmployeeDTO updateEmployeeDTO(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        employee.setId(id);
        Employee updatedEmployee = employeePayrollService.updateEmployeeInRepository(id, employee);
        return EmployeeMapper.toDTO(updatedEmployee);
    }
}