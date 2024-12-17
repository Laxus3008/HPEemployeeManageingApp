package com.HPEEmpDetails.EmployeeDetails.controller;

import com.HPEEmpDetails.EmployeeDetails.entity.Employee;
import com.HPEEmpDetails.EmployeeDetails.entity.Employees;
import com.HPEEmpDetails.EmployeeDetails.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empdetails")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/allemployees")
    public ResponseEntity<?> getAllEmployees() {

        List<Employee> allEmployees = employeesService.getAllEmployees();

        if(allEmployees != null && !allEmployees.isEmpty()) {
            return new ResponseEntity<>(allEmployees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

        try{
            employeesService.addEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
