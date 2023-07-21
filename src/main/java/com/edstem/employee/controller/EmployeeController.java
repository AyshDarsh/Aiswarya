package com.edstem.employee.controller;

import com.edstem.employee.contract.EmployeeDto;
import com.edstem.employee.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with ID " + id + " has been deleted.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable int id, @Valid @RequestBody EmployeeDto employee) {
        EmployeeDto updatedEmployee = employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employee) {
        EmployeeDto employeeDto = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
}
