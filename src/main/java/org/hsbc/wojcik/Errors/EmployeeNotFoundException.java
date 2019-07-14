package org.hsbc.wojcik.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND )
public class EmployeeNotFoundException  extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Employee not found {id}: " + id);
    }
}
