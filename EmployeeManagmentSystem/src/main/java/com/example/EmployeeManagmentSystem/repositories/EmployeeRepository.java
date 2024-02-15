package com.example.EmployeeManagmentSystem.repositories;


import com.example.EmployeeManagmentSystem.model.entities.Department;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(Department department);
}
