package com.example.EmployeeManagmentSystem.mapping;

import com.example.EmployeeManagmentSystem.dtos.DepartmentDto;
import com.example.EmployeeManagmentSystem.model.entities.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T01:42:26+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto DepartmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentNumber( department.getDepartmentNumber() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setDepartmentLocation( department.getDepartmentLocation() );

        return departmentDto;
    }

    @Override
    public Department DepartmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.departmentNumber( departmentDto.getDepartmentNumber() );
        department.departmentName( departmentDto.getDepartmentName() );
        department.departmentLocation( departmentDto.getDepartmentLocation() );

        return department.build();
    }

    @Override
    public Department updateDepartment(DepartmentDto departmentDto, Department department) {
        if ( departmentDto == null ) {
            return department;
        }

        if ( departmentDto.getDepartmentNumber() != null ) {
            department.setDepartmentNumber( departmentDto.getDepartmentNumber() );
        }
        if ( departmentDto.getDepartmentName() != null ) {
            department.setDepartmentName( departmentDto.getDepartmentName() );
        }
        if ( departmentDto.getDepartmentLocation() != null ) {
            department.setDepartmentLocation( departmentDto.getDepartmentLocation() );
        }

        return department;
    }
}
