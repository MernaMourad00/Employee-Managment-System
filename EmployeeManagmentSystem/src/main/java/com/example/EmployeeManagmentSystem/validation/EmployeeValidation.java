package com.example.EmployeeManagmentSystem.validation;


import com.example.EmployeeManagmentSystem.Services.impl.EmployeeServiceImpl;
import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;
import com.example.EmployeeManagmentSystem.exception.EmployeeException;
import com.example.EmployeeManagmentSystem.model.constants.enums.ExceptionMessages;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.EmployeeManagmentSystem.model.constants.enums.Constants.*;

@Component
public class EmployeeValidation {

    @Autowired
    private final EmployeeServiceImpl employeeService;

    public EmployeeValidation(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public void emailValidation(String email) {

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new EmployeeException(ExceptionMessages.INVALID_EMAIL.getMessage());
        }

    }

    public void doesEmployeeExist(Integer id){
       Optional<Employee> employee = employeeService.getByid(id);
       if(!employee.isPresent()){
           throw  new EmployeeException(ExceptionMessages.EMPLOYEE_NOT_FOUND.getMessage());
       }

    }

    public List<EmployeeDto> isEmployeeListEmpty(){
        List<EmployeeDto> employees = employeeService.getEmployees();

        if(employees.isEmpty()){
            throw new EmployeeException(ExceptionMessages.NO_EMPLOYEES_FOUND.getMessage());
        }
        else {
            return employees;
        }
    }


}
