package com.example.EmployeeManagmentSystem.repository;

import com.example.EmployeeManagmentSystem.model.entities.Employee;
import com.example.EmployeeManagmentSystem.repositories.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTests {

    @Autowired
    private  EmployeeRepository employeeRepository;


    @Test
    public void isEmployeeSaved(){

        //Arrange

        Employee employee = Employee.builder()
                .name("layla")
                .email("layla@gmail.com")
                .role("developer")
                .build();

        //Act

        Employee savedEmployee = this.employeeRepository.save(employee);

        //Assert
        assertNotNull(savedEmployee);
        assertTrue(savedEmployee.getId() > 0);


    }

}
