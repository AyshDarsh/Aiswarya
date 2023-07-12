package com.in28minutes.employeecrud.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class employeeDaoService {

    private static final List<Employee> employees=new ArrayList<>();
    private  static  int employeesCount=0;
    static {
        employees.add(new Employee(++employeesCount,"Amrita","K","amritha@gmail.com","9388373334","Associate","IT"));
        employees.add(new Employee(++employeesCount,"Alok","E","alok@gmail.com","9375434234","Associate","IT"));
        employees.add(new Employee(++employeesCount,"Adithya","N","adithya@gmail.com","9673423854","Associate","IT"));
    }
    public List<Employee> findAll(){
        return employees;
    }
    public Employee findOne(int id){
        Predicate<? super Employee> predicate=employee ->employee.getId().equals(id);
        return employees.stream().filter(predicate).findFirst().orElse(null);

    }
    public void deleteById(int id){
        Predicate<? super Employee> predicate=employee ->employee.getId().equals(id);
        employees.removeIf(predicate);

    }

    public Employee save(Employee employee){
        employee.setId(++employeesCount);
        employees.add(employee);
        return  employee;
    }



}

