package com.edstem.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class FirstNameValidator implements ConstraintValidator<ValidFirstName, String> {

    @Override
    public boolean isValid(String firstname, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(firstname) && firstname.length() >= 3;
    }
}
