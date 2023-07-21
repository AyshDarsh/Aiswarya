package com.edstem.employee.validation;

import jakarta.validation.Payload;
import java.lang.annotation.*;

public @interface ValidLastName {
    String message() default "LastName cant be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
