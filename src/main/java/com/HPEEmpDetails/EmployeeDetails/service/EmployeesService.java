package com.HPEEmpDetails.EmployeeDetails.service;

import com.HPEEmpDetails.EmployeeDetails.entity.Employee;
import com.HPEEmpDetails.EmployeeDetails.repository.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeeManager manager;

    public List<Employee> getAllEmployees() {
        return manager.getAllEmployees();
    }

    public boolean addEmployee(Employee emp) {

        try{
            manager.addEmployee(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
