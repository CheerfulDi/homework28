package pro.sky.java.course2.homework28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.EmployeeService;

import java.util.Collection;


@RestController
@RequestMapping(path="/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam double salary,
                      @RequestParam Integer departmentId) {
        employeeService.addToEmployeeList(firstName, lastName, salary, departmentId);
        return "Сотрудник " + firstName + " " + lastName + " успешно добавлен в отдел " + departmentId;
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "Сотрудник удалён.";
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/get/employees")
    public Collection<Employee> get() {
        return employeeService.getEmployees();
    }

}
