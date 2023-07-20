package com.edstem.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Email provided is not valid ,should have 2 names separated by @";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
