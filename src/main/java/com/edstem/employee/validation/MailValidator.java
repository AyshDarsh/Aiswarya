package com.edstem.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolationException;
import org.springframework.util.StringUtils;

public class MailValidator implements ConstraintValidator<ValidEmail,String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(email)&&email.split("@").length==2;
    }
}
