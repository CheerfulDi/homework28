package pro.sky.java.course2.homework28.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Employee book is full")
public class EmployeeBookOverFlowException extends RuntimeException{

    public EmployeeBookOverFlowException() {
        super("Employee book is full");
    }
}
