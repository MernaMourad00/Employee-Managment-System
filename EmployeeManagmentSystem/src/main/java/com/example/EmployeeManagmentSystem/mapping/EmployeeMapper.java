package com.example.EmployeeManagmentSystem.mapping;

import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeDto employeeToEmployeeDto(Employee employee);
  Employee employeDtoToEmployee(EmployeeDto employeeDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Employee updateEmployee(EmployeeDto employeeDto, @MappingTarget Employee employee);

}
