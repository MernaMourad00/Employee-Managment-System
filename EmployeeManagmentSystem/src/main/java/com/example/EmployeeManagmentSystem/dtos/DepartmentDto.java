package com.example.EmployeeManagmentSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    Integer departmentNumber;
    String departmentName;
    String departmentLocation;

}
