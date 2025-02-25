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

    // Old functionality (using Employee)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeePayrollService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeePayrollService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeePayrollService.deleteEmployee(id);
    }


    @GetMapping("/dto")
    public List<EmployeeDTO> getAllEmployeesDTO() {
        List<Employee> employees = employeePayrollService.getAllEmployees();
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/dto/{id}")
    public EmployeeDTO getEmployeeDTOById(@PathVariable Long id) {
        Employee employee = employeePayrollService.getEmployeeById(id);
        return EmployeeMapper.toDTO(employee);
    }

    @PostMapping("/dto")
    public EmployeeDTO addEmployeeDTO(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeePayrollService.addEmployee(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }

    @PutMapping("/dto/{id}")
    public EmployeeDTO updateEmployeeDTO(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        employee.setId(id);
        Employee updatedEmployee = employeePayrollService.updateEmployee(id, employee);
        return EmployeeMapper.toDTO(updatedEmployee);
    }
}