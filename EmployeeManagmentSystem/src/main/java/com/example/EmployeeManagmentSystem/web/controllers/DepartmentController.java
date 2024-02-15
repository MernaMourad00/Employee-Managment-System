package com.example.EmployeeManagmentSystem.web.controllers;

import com.example.EmployeeManagmentSystem.Services.DepartmentService;
import com.example.EmployeeManagmentSystem.dtos.DepartmentDto;
import com.example.EmployeeManagmentSystem.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @GetMapping("/all")
    public ResponseEntity<ResponseModel> getDepartments() {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(departmentService.getDepartments());
        responseModel.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addDepartment(@RequestBody DepartmentDto departmentDto) {


        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(departmentService.addDepartment(departmentDto));
        responseModel.setHttpStatus(HttpStatus.OK);
        return  ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);



    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseModel> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {

        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto);
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(updatedDepartment);
        responseModel.setHttpStatus(HttpStatus.OK);

        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }


}
