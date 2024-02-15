package com.example.EmployeeManagmentSystem.mapping;

import com.example.EmployeeManagmentSystem.dtos.DepartmentDto;
import com.example.EmployeeManagmentSystem.model.entities.Department;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto DepartmentToDepartmentDto(Department department);

    Department DepartmentDtoToDepartment(DepartmentDto departmentDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department updateDepartment(DepartmentDto departmentDto, @MappingTarget Department department);


}
