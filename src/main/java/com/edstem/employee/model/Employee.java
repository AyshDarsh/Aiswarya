package com.edstem.employee.model;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;


}


