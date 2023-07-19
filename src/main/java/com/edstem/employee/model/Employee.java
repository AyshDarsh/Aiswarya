package com.edstem.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private int id;
    @NotBlank(message="First name is required")
    @Size(min=3, message="name contain at least three letters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Position cannot be empty")
    private String position;

    @NotBlank(message = "Department cannot be empty")
    private String department;;

}


