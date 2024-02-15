package com.example.EmployeeManagmentSystem.mapping;

import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T01:42:26+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setEmail( employee.getEmail() );
        employeeDto.setRole( employee.getRole() );
        employeeDto.setDepartment( employee.getDepartment() );

        return employeeDto;
    }

    @Override
    public Employee employeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDto.getId() );
        employee.name( employeeDto.getName() );
        employee.email( employeeDto.getEmail() );
        employee.role( employeeDto.getRole() );
        employee.department( employeeDto.getDepartment() );

        return employee.build();
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto, Employee employee) {
        if ( employeeDto == null ) {
            return employee;
        }

        if ( employeeDto.getId() != null ) {
            employee.setId( employeeDto.getId() );
        }
        if ( employeeDto.getName() != null ) {
            employee.setName( employeeDto.getName() );
        }
        if ( employeeDto.getEmail() != null ) {
            employee.setEmail( employeeDto.getEmail() );
        }
        if ( employeeDto.getRole() != null ) {
            employee.setRole( employeeDto.getRole() );
        }
        if ( employeeDto.getDepartment() != null ) {
            employee.setDepartment( employeeDto.getDepartment() );
        }

        return employee;
    }
}
