package com.example.EmployeeManagmentSystem.Services;

import com.example.EmployeeManagmentSystem.dtos.DepartmentDto;
import com.example.EmployeeManagmentSystem.model.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<DepartmentDto> getDepartments();
    DepartmentDto addDepartment(DepartmentDto employeeDto);
    DepartmentDto updateDepartment(DepartmentDto employeeDto);
    void deleteDepartment(Integer id);

    Optional<Department> getByid(Integer departmentId);
}
