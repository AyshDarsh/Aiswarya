package com.edstem.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface ValidPhone {
    String message() default "Phone can't be empty, Should contain 10 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

