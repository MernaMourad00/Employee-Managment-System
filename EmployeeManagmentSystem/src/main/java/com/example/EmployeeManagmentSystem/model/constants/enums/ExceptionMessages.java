package com.example.EmployeeManagmentSystem.model.constants.enums;

public enum ExceptionMessages {
    NO_EMPLOYEES_FOUND("No employees found"),
    INVALID_EMAIL("Please enter a valid email."),
    EMPLOYEE_NOT_FOUND("Employee does't exist");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
