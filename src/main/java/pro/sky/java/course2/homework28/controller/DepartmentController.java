package pro.sky.java.course2.homework28.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryEmployee(@RequestParam Integer departmentId) {
        return departmentService.findMinSalaryEmployee(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryEmployee(@RequestParam Integer departmentId) {
        return departmentService.findMaxSalaryEmployee(departmentId);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> getEmployeesByDepartment(
            @RequestParam (required = false) Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getEmployeesByDepartment(departmentId);
        }
            return departmentService.getAllEmployees();
        }
    }
