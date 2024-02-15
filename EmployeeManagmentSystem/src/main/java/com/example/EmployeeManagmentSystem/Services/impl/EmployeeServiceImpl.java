package com.example.EmployeeManagmentSystem.Services.impl;

import com.example.EmployeeManagmentSystem.Services.EmployeeService;
import com.example.EmployeeManagmentSystem.dtos.EmployeeDto;
import com.example.EmployeeManagmentSystem.mapping.EmployeeMapper;
import com.example.EmployeeManagmentSystem.model.entities.Department;
import com.example.EmployeeManagmentSystem.model.entities.Employee;
import com.example.EmployeeManagmentSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

//    @Cacheable(cacheNames = "employees")
    @Override
    public List<EmployeeDto> getEmployees() {

        return employeeRepository.findAll().stream().map(employeeMapper::employeeToEmployeeDto).collect(Collectors.toList());
    }
    public Optional<Employee> getByid(Integer id){
        return employeeRepository.findById(id);
    }

//    @CacheEvict(value = "employees",allEntries = true)
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
       Employee employee = employeeMapper.employeDtoToEmployee(employeeDto);
        Employee emp = employeeRepository.save(employee);
       return employeeMapper.employeeToEmployeeDto(emp);
    }

//    @CachePut(cacheNames = "employees", key = "#updatedEmployee.id")
    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.employeDtoToEmployee(employeeDto);

        Employee emp2 = employeeMapper.updateEmployee(employeeDto,employee);

        EmployeeDto employeeDto1=  employeeMapper.employeeToEmployeeDto(emp2);

        employeeRepository.save(emp2);

        return employeeDto1;

    }
//    @CacheEvict(cacheNames = "employees",key = "#id")
    @Override
    public void deleteEmployee(Integer id) {
         employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }


}
