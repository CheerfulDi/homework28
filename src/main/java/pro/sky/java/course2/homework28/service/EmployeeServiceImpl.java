package pro.sky.java.course2.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework28.exceptions.EmployeeExistException;
import pro.sky.java.course2.homework28.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework28.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>();

    @Override
    public void addToEmployeeList(String firstName, String lastName, double salary, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        String key = firstName+lastName;
        if (employees.containsKey(key)) {
            throw new EmployeeExistException();
        } else employees.put(key, employee);
    }

    @Override
    public void removeEmployee (String firstName, String lastName) {
        String key = firstName+lastName;
        if (employees.containsKey(key)) {
            employees.remove(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee (String firstName, String lastName) {
        String key = firstName+lastName;
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

}

