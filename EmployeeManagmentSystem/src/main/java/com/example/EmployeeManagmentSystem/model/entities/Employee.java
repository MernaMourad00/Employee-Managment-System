package com.example.EmployeeManagmentSystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Integer id;
    @Column(updatable = false , nullable = false)
    private String name;
    @Column(nullable = false)
    private  String email;
    @Column
    private  String role;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

}
