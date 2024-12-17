package com.HPEEmpDetails.EmployeeDetails.service;

import com.HPEEmpDetails.EmployeeDetails.entity.Employee;
import com.HPEEmpDetails.EmployeeDetails.repository.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeesServiceTest {

    @Mock
    private EmployeeManager employeeManager;

    @Autowired
    @InjectMocks
    private EmployeesService employeesService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEmployees() {

        List<Employee> mockEmployees = Arrays.asList(
                new Employee("1001", "John", "Doe", "john.doe@example.com", "Developer"),
                new Employee("1002", "Jane", "Doe", "jane.doe@example.com", "Tester")
        );
        when(employeeManager.getAllEmployees()).thenReturn(mockEmployees);
        List<Employee> result = employeesService.getAllEmployees();

        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "The result should contain 2 employees");
        assertEquals("John", result.get(0).getFirst_name(), "First employee's name should be John");
        assertEquals("Jane", result.get(1).getFirst_name(), "Second employee's name should be Jane");

        // Verify interactions with the mock
        Mockito.verify(employeeManager, times(1)).getAllEmployees();

    }

    @ParameterizedTest
    @ArgumentsSource(EmployeeArgumentsProvider.class)
    public void testADDNewEmployee(Employee employee) {

        assertTrue(employeesService.addEmployee(employee));
    }
}
