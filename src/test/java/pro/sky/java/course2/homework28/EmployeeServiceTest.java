package pro.sky.java.course2.homework28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.homework28.exceptions.EmployeeExistException;
import pro.sky.java.course2.homework28.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.homework28.EmployeeServiceTestConstants.*;

public class EmployeeServiceTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    private static Employee employee1;
    private static Employee employee2;
    Map<String, Employee> employeesForTest = new HashMap<>();


    @BeforeEach
    public void setUp() {
        employee1 = new Employee(DEFAULT_NAME1, DEFAULT_LAST_NAME1, SALARY1, DEPARTMENT1);
        employee2 = new Employee(DEFAULT_NAME2, DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2);
        employeesForTest.put(DEFAULT_NAME1 + DEFAULT_LAST_NAME1,employee1);
        employeesForTest.put(DEFAULT_NAME2 + DEFAULT_LAST_NAME2,employee2);
    }

    @Test
    public void shouldThrowExceptionAfterCheckingStrings() {
        assertThrows(RuntimeException.class,
                ()-> out.findEmployee(INCORRECT_NAME1, INCORRECT_LAST_NAME1),
                "Имя и/или фамилия содержит недопустимые символы");

    }

    @Test
    public void shouldAddToEmployeeList() {
        out.addToEmployeeList(DEFAULT_NAME1,DEFAULT_LAST_NAME1, SALARY1, DEPARTMENT1);
        assertEquals(employee1, out.findEmployee(DEFAULT_NAME1,DEFAULT_LAST_NAME1));
    }

    @Test
    public void shouldThrowEmployeeExistException() {
        out.addToEmployeeList(DEFAULT_NAME1,DEFAULT_LAST_NAME1, SALARY1, DEPARTMENT1);
        assertThrows(EmployeeExistException.class,
                ()-> out.addToEmployeeList(DEFAULT_NAME1, DEFAULT_LAST_NAME1,SALARY1,DEPARTMENT1),
                "Employee is already exists");
    }

    @Test
    public void shouldRemoveEmployee() {

    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        out.addToEmployeeList(DEFAULT_NAME1,DEFAULT_LAST_NAME1, SALARY1, DEPARTMENT1);
        assertThrows(EmployeeNotFoundException.class,
                ()-> out.findEmployee(DEFAULT_NAME2,DEFAULT_LAST_NAME2),
                "Employee is not found");
    }

    @Test
    public void shouldFindEmployee() {
        out.addToEmployeeList(DEFAULT_NAME2,DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2);
        assertEquals(employee2, out.findEmployee(DEFAULT_NAME2,DEFAULT_LAST_NAME2));

    }

    @Test
    public void shouldGetEmployees() {
        out.addToEmployeeList(DEFAULT_NAME1,DEFAULT_LAST_NAME1, SALARY1, DEPARTMENT1);
        out.addToEmployeeList(DEFAULT_NAME2,DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2);
        assertEquals(employeesForTest.values().size(), out.getEmployees().size());

    }
}
