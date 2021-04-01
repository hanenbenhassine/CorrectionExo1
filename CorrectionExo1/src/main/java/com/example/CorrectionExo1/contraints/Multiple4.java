package com.example.CorrectionExo1.contraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {Multiple4Validitor.class})
public @interface Multiple4 {
    String message() default "{Il y a 50 ans, les notes etaient de 0 à 10}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
