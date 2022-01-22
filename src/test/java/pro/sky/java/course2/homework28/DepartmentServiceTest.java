package pro.sky.java.course2.homework28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.DepartmentServiceImpl;
import pro.sky.java.course2.homework28.service.EmployeeService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static pro.sky.java.course2.homework28.TestConstants.*;
@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeServiceMock.getEmployees()).thenReturn(List.of(
                new Employee(DEFAULT_NAME1,DEFAULT_LAST_NAME1,SALARY1, DEPARTMENT1),
                new Employee(DEFAULT_NAME2, DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2)
        ));
    }

    @Test
    public void testMinSalary() {
        Employee actual = out.findMinSalaryEmployee(DEPARTMENT1);
        Employee expected = new Employee(DEFAULT_NAME1,DEFAULT_LAST_NAME1,SALARY1, DEPARTMENT1);
        assertEquals(expected,actual);

    }

    @Test
    public void testMaxSalary() {
        Employee actual = out.findMaxSalaryEmployee(DEPARTMENT1);
        Employee expected = new Employee(DEFAULT_NAME2,DEFAULT_LAST_NAME2,SALARY2, DEPARTMENT2);
        assertEquals(expected,actual);

    }

    @Test
    public void shouldGetEmployeesByDepartment() {
        Collection<Employee> actual = out.getEmployeesByDepartment(DEPARTMENT1);
        Collection<Employee> expected = List.of(
                new Employee(DEFAULT_NAME1,DEFAULT_LAST_NAME1,SALARY1, DEPARTMENT1),
                new Employee(DEFAULT_NAME2, DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2)
        );
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testGetEmployeesIfDepartmentIsEmpty() {
        Collection<Employee> actual = out.getEmployeesByDepartment(DEPARTMENT3);
        List<Employee> expected = Collections.emptyList();
        assertEquals(expected,actual);
    }

    @Test
    public void shouldGetAllEmployees() {
        Collection<Employee> actual = out.getAllEmployees();
        Collection<Employee> expected = List.of(
                new Employee(DEFAULT_NAME1,DEFAULT_LAST_NAME1,SALARY1, DEPARTMENT1),
                new Employee(DEFAULT_NAME2, DEFAULT_LAST_NAME2, SALARY2, DEPARTMENT2)
        );
        assertEquals(expected.size(),actual.size());
    }

}
