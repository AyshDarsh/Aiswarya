package com.edstem.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class LastNameValidator implements ConstraintValidator<ValidLastName, String> {

    @Override
    public boolean isValid(String lastname, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(lastname) && lastname.length() >= 1;
    }
}

