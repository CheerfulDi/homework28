package pro.sky.java.course2.homework28.service;

import pro.sky.java.course2.homework28.model.Employee;

import java.util.Collection;

public interface DepartmentService {

    Employee findMinSalaryEmployee(Integer departmentId);
    Employee findMaxSalaryEmployee(Integer departmentId);
    Collection<Employee> getEmployeesByDepartment(Integer departmentId);
    Collection<Employee> getAllEmployees();

}
