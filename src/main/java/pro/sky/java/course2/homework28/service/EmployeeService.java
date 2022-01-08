package pro.sky.java.course2.homework28.service;


import pro.sky.java.course2.homework28.exceptions.EmployeeExistException;
import pro.sky.java.course2.homework28.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.homework28.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    void addToEmployeeList(String firstName, String lastName, double salary, Integer departmentId) throws EmployeeExistException;

    void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> getEmployees();

}