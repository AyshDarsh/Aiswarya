package com.edstem.employee.contract;

import com.edstem.employee.validation.ValidEmail;
import com.edstem.employee.validation.ValidFirstName;
import com.edstem.employee.validation.ValidLastName;
import com.edstem.employee.validation.ValidPhone;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private int id;

    @ValidFirstName private String firstName;

    @ValidLastName private String lastName;

    @ValidEmail private String email;

    @ValidPhone private String phone;

    @NotBlank(message = "Position cannot be empty")
    private String position;

    @NotBlank(message = "Department cannot be empty")
    private String department;
}
