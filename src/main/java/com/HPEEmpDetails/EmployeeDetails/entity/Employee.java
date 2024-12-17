package com.HPEEmpDetails.EmployeeDetails.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @NonNull
    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}
