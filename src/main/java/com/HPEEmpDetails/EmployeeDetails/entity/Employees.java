package com.HPEEmpDetails.EmployeeDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    private List<Employee> allEmployees = new ArrayList<>();
}
