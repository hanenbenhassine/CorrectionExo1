package com.example.CorrectionExo1.contraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Multiple4Validitor implements ConstraintValidator<Multiple4,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

            return value%4==0;

    }
}
