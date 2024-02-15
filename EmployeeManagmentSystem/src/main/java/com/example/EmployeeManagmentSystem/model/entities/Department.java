package com.example.EmployeeManagmentSystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    Integer departmentNumber;
    @Column(updatable = false)
    String departmentName;
    @Column
    String departmentLocation;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employeeList = new ArrayList<>();

    //left join fetch
    //eager/lazy fetch

}
