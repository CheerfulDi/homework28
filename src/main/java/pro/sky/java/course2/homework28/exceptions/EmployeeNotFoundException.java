package pro.sky.java.course2.homework28.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee is not found")
public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException() {
        super("Employee is not found");
    }

}
