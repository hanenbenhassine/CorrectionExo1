package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.ProfessorDTO;
import com.example.CorrectionExo1.service.CrudSerivce;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prof")
@Profile("api")
public class ProfessorControllor extends AbstractCrudController<ProfessorDTO,Integer> {
    protected ProfessorControllor(CrudSerivce<ProfessorDTO, Integer> service) {
        super(service);
    }

    }

