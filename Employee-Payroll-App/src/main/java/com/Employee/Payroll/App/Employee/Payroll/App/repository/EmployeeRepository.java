package com.Employee.Payroll.App.Employee.Payroll.App.repository;

import com.Employee.Payroll.App.Employee.Payroll.App.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}