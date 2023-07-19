package com.edstem.employee.service;

import com.edstem.employee.contract.EmployeeDto;
import com.edstem.employee.model.Employee;
import com.edstem.employee.exception.EmployeeNotFoundException;
import com.edstem.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees.stream().map(employee -> modelMapper
                .map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> {
            log.error("Employee with id:{} not found", id);
            return new EmployeeNotFoundException(id);
        });
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateBookById(int id, EmployeeDto employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> {
            log.error("Book with id: {} not found", id);
            return new EmployeeNotFoundException(id);
        });
        modelMapper.map(employee, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);

    }

    public EmployeeDto addEmployee(EmployeeDto employee) {
        Employee  employeeEntity=modelMapper.map(employee, Employee.class);
        Employee savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDto.class);

    }

}

