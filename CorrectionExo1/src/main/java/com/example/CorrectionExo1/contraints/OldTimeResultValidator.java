package com.example.CorrectionExo1.contraints;

import com.example.CorrectionExo1.dto.StudentDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class OldTimeResultValidator implements ConstraintValidator<OldTimeResults, StudentDTO> {
    @Override
    public boolean isValid(StudentDTO studentDTO, ConstraintValidatorContext context) {
        if(studentDTO.getBirthDate()==null || studentDTO.getResult()==null){
            return false;
        }
        if(studentDTO.getBirthDate().isBefore(LocalDateTime.now().minusYears(50)))
        {
            context.disableDefaultConstraintViolation();
            if(studentDTO.getResult()< 0){
                context.buildConstraintViolationWithTemplate("{+50 ans et result <0}").addConstraintViolation();
            return false;
            }
            else if(studentDTO.getResult()>10) {
                context.buildConstraintViolationWithTemplate("{+50 ans et result >10}").addConstraintViolation();

                return false;
            }
        }
        return true;
    }
}
