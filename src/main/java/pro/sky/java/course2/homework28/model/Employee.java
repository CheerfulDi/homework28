package pro.sky.java.course2.homework28.model;

import java.util.Objects;

import static java.lang.String.format;

public class Employee {

    private static final int MIN_DEPARTMENT = 1;
    private static final int MAX_DEPARTMENT = 5;

    private final String firstName;
    private final String lastName;
    private double salary;
    private Integer departmentId;


    public Employee(String firstName, String lastName, double salary, Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int newDepartmentId) {
        if (departmentId >= MIN_DEPARTMENT && departmentId <= MAX_DEPARTMENT) {
            departmentId = newDepartmentId;
        } else {
            throw new IllegalArgumentException("В компании всего 5 департаментов. Пожалуйста, введите значение от 1 до 5.");
        }
    }

    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName + ". Зарплата: " + format("%.2f", salary) + ". Отдел: " + departmentId + ".";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 && getFirstName().equals(employee.getFirstName()) && getLastName().equals(employee.getLastName()) && departmentId.equals(employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getSalary(), departmentId);
    }
}
