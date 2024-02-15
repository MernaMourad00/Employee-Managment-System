package com.example.EmployeeManagmentSystem.web.controllers;

import com.example.EmployeeManagmentSystem.Services.DepartmentService;
import com.example.EmployeeManagmentSystem.Services.impl.EmployeeServiceImpl;
import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;
import com.example.EmployeeManagmentSystem.model.entities.Department;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import com.example.EmployeeManagmentSystem.validation.EmployeeValidation;
import com.example.EmployeeManagmentSystem.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    EmployeeValidation employeeValidation;

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/all")
    public ResponseEntity<ResponseModel> getEmployees() {
        System.out.println("In get employees");

       List<EmployeeDto> employees = employeeValidation.isEmployeeListEmpty();
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(employees);
        responseModel.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addEmployee(@RequestBody EmployeeDto employeeDto) {

           employeeValidation.emailValidation(employeeDto.getEmail());

           EmployeeDto addedEmployee = employeeService.addEmployee(employeeDto);
           ResponseModel responseModel = new ResponseModel();
           responseModel.setData(addedEmployee);
           responseModel.setHttpStatus(HttpStatus.OK);
           return  ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);



    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseModel> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto emp) {
        employeeValidation.doesEmployeeExist(id);
        EmployeeDto updatedEmployee = employeeService.updateEmployee(emp);
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(updatedEmployee);
        responseModel.setHttpStatus(HttpStatus.OK);

        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeValidation.doesEmployeeExist(id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getByDept/{departmentId}")
    public List<Employee> getEmployeesInDepartment(@PathVariable Integer departmentId) {

        Department department = new Department();
        department.setDepartmentNumber(departmentId);
       return employeeService.getEmployeesByDepartment(department);

    }


}
