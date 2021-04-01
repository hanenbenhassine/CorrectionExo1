package com.example.CorrectionExo1.contraints;

import com.example.CorrectionExo1.dto.ProfessorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.*;

public class WageValidator implements ConstraintValidator<Waged, ProfessorDTO> {
    @Override
    public boolean isValid(ProfessorDTO professorDTO, ConstraintValidatorContext constraintValidatorContext) {

       long years= Period.between(professorDTO.getHireDate().toLocalDate(), LocalDate.now()).getYears();
       int min=1500;
       if(years>20){
           min+=100*((years-20)/5);
       }

           constraintValidatorContext.disableDefaultConstraintViolation();
           constraintValidatorContext.buildConstraintViolationWithTemplate("wage min : " + min).addConstraintViolation();

        return professorDTO.getWage()>=min;
    }
}
