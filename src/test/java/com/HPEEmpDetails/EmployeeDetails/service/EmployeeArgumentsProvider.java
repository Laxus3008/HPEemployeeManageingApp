package com.HPEEmpDetails.EmployeeDetails.service;

import com.HPEEmpDetails.EmployeeDetails.entity.Employee;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class EmployeeArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(Employee.builder().employee_id("8005").first_name("raman").last_name("lal").email("xyz@gmail.com").title("None").build()),
                Arguments.of(Employee.builder().employee_id("8006").first_name("shayam").last_name("lal").email("xyz@gmail.com").title("None").build())
                );
    }
}
