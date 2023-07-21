package com.edstem.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(phone) && phone.length() == 10;
    }
}
