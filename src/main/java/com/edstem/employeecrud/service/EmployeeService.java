package com.edstem.employeecrud.service;

import com.edstem.employeecrud.contract.EmployeeResponse;
import com.edstem.employeecrud.contract.Employee;
import com.edstem.employeecrud.exception.EmployeeNotFoundException;
import com.edstem.employeecrud.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees.stream().map(employee -> modelMapper
                .map(employee,EmployeeResponse.class)).collect(Collectors.toList());
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> {
            log.error("Employee with id:{} not found", id);
            return new EmployeeNotFoundException(id);
        });
        return modelMapper.map(employee,EmployeeResponse.class);
    }

    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    public EmployeeResponse addEmployee(Employee employee){

        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeResponse.class);

    }

}

