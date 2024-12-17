package com.HPEEmpDetails.EmployeeDetails.repository;

import com.HPEEmpDetails.EmployeeDetails.entity.Employee;
import com.HPEEmpDetails.EmployeeDetails.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeManager {

    private final Employees employees;

    // Constructor for dependency injection or initialization
    public EmployeeManager() {
        // Initialize the Employees object
        employees = Employees.builder()
                .allEmployees(new ArrayList<>()) // Initialize the list
                .build();

        // Add Employee instances
        employees.getAllEmployees().add(new Employee("E001", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        employees.getAllEmployees().add(new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "Product Manager"));
        employees.getAllEmployees().add(new Employee("E003", "Sam", "Wilson", "sam.wilson@example.com", "Data Analyst"));
    }

    // Getter for all employees
    public List<Employee> getAllEmployees() {
        return employees.getAllEmployees();
    }

    public void addEmployee(Employee emp) {

        employees.getAllEmployees().add(emp);
    }
}
