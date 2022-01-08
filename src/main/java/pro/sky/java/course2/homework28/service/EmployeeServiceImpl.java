package pro.sky.java.course2.homework28.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import pro.sky.java.course2.homework28.exceptions.EmployeeExistException;
import pro.sky.java.course2.homework28.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework28.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>();
    private Throwable BadRequest;

    public boolean checkStrings (String firstName, String lastName) throws RuntimeException {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
                return true;
            }
            throw new RuntimeException("Имя и/или фамилия содержит недопустимые символы", BadRequest);
        }


    @Override
    public void addToEmployeeList(String firstName, String lastName, double salary, Integer departmentId) {
        checkStrings(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, salary, departmentId);

        String key = firstName+lastName;
        if (employees.containsKey(key)) {
            throw new EmployeeExistException();
        } else employees.put(key, employee);
    }

    @Override
    public void removeEmployee (String firstName, String lastName) {
        checkStrings(firstName, lastName);

        String key = firstName+lastName;
        if (employees.containsKey(key)) {
            employees.remove(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee (String firstName, String lastName) {
        checkStrings(firstName, lastName);

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

