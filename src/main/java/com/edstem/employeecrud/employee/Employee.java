package com.edstem.employeecrud.employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

        //id, firstName, lastName, email,phone, position, department
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String position;
        private String department;

}


