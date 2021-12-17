package pro.sky.java.course2.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework28.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findMinSalaryEmployee(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }


    @Override
    public Employee findMaxSalaryEmployee(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employee> getEmployeesByDepartment(Integer departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}
