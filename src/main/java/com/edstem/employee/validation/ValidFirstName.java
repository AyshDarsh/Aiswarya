package com.edstem.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FirstNameValidator.class)
@Documented
public @interface ValidFirstName {
    String message() default "FirstName should contain at least 3 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
