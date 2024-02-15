package com.example.EmployeeManagmentSystem.Services.impl;

import com.example.EmployeeManagmentSystem.Services.DepartmentService;
import com.example.EmployeeManagmentSystem.dtos.DepartmentDto;
import com.example.EmployeeManagmentSystem.mapping.DepartmentMapper;
import com.example.EmployeeManagmentSystem.model.entities.Department;
import com.example.EmployeeManagmentSystem.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDto> getDepartments() {
        return departmentRepository
                .findAll()
                .stream().
                map(departmentMapper::DepartmentToDepartmentDto).
                collect(Collectors.toList());
    }

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.DepartmentDtoToDepartment(departmentDto);
        Department department2 = departmentRepository.save(department);
        return departmentMapper.DepartmentToDepartmentDto(department2);
    }

    public Optional<Department> getByid(Integer id){
        return departmentRepository.findById(id);
    }
    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {

        Department department = departmentMapper.DepartmentDtoToDepartment(departmentDto);

        Department department2 = departmentMapper.updateDepartment(departmentDto,department);

        DepartmentDto departmentDto2=  departmentMapper.DepartmentToDepartmentDto(department2);

        departmentRepository.save(department2);

        return departmentDto2;
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);

    }
}
