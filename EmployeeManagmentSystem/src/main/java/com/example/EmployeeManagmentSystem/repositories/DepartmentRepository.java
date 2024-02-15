package com.example.EmployeeManagmentSystem.repositories;


import com.example.EmployeeManagmentSystem.model.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
