package com.in28minutes.employeecrud.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private employeeDaoService service;
    @Autowired

    public EmployeeController(employeeDaoService service) {
        this.service = service;
    }
    //get all employees
    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees() {
        return service.findAll();
    }
    //get one employee
    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id) throws UserNotFoundException {
        Employee employee = service.findOne(id);

        if(employee==null)
            throw new UserNotFoundException("id" +id);

        return employee;
    }
    //delete a user
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteById(id);

    }
    //create employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee=service.save(employee);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(null).build();
    }



}


