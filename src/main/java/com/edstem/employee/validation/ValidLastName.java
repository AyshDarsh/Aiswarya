package com.edstem.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LastNameValidator.class)
@Documented
public @interface ValidLastName {
    String message() default "FirstName cant be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
