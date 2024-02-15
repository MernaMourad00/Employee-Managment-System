package com.example.EmployeeManagmentSystem.repositories.impl;


import com.example.EmployeeManagmentSystem.model.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class EmployeeRepositoryImpl  {

    private final List<Employee> employeeList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);


    public List<Employee> getEmployees() {
        return employeeList;
    }


    public Employee addEmployee(Employee emp) {

        employeeList.add(emp);
        return emp;
    }


    public Employee updateEmployee(Integer id, Employee emp) {
        Optional<Employee> employeeToUpdate = employeeList.stream()
                .filter(x -> x.getId() == id)
                .findFirst();

        if (employeeToUpdate.isPresent()) {
            employeeToUpdate.get().setName(emp.getName());

            return employeeToUpdate.get();
        }

        return null;
    }


    public Boolean deleteEmployee(Integer id) {
//        Optional<Employee> employeeToUpdate = employeeList.stream()
//                .filter(x -> x.getId().equals(id))
//                .findFirst();

        return employeeList.removeIf(employee -> employee.getId().equals(id));
//        if(employeeToUpdate.isPresent()) {
//            System.out.println(employeeList.remove(employeeToUpdate));
//            return employeeList.remove(employeeToUpdate);
//        }
//        else
//            return false;

    }

//    private List<Employee> getEmployeeList(){
//
//        Employee emp = new Employee(1,"merna","bdjsv@gmail.com","manager");
//
//        employeeList.add(emp);
//        return employeeList;
//    }

}
