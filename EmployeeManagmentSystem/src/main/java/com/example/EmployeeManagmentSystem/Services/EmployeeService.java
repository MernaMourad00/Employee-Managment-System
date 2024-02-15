package com.example.EmployeeManagmentSystem.Services;



import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Integer id);
}
