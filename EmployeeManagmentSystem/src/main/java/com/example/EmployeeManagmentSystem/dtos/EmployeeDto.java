package com.example.EmployeeManagmentSystem.dtos;

import com.example.EmployeeManagmentSystem.model.entities.Department;
import lombok.*;
;import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

    private Integer id;
    private String name;
    private  String email;
    private  String role;
    private Department department;

}
