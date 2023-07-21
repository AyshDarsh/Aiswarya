package com.edstem.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int id) {

        super("Not find with this employee id:" + id);
    }
}
