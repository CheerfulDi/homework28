package pro.sky.java.course2.homework28.list;

import pro.sky.java.course2.homework28.model.Employee;

public class Node {
    Node next;
    Employee employee;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
