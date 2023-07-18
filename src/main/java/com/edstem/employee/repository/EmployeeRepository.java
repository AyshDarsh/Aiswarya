package com.edstem.employee.repository;

import com.edstem.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

    Optional<Employee> findById(int id);


}
