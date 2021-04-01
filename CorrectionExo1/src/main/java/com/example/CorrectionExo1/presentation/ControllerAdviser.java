package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.exception.DemoException;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.exception.WrongPageException;
import com.example.CorrectionExo1.rapport.Rapport;
import com.example.CorrectionExo1.rapport.RapportValidation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

//cette classe va rassempler tout les exceptions de tout les controlleurs
@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DemoException.class)
    public ResponseEntity<String> demoHandler(DemoException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(request.getRequestURI()+"->Depuis le controller advice");

    }
    @ExceptionHandler({ElementNotFoundException.class,ElementsAlreadyExistsException.class})
    public ResponseEntity<Rapport>handleElementNotFound(Exception e,HttpServletRequest request){
        Rapport rapport= new Rapport(
                e.getMessage(), HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()
                );
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(rapport);
    }
    @ExceptionHandler(WrongPageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Rapport handleWrongPage(WrongPageException e, WebRequest request){
        return new Rapport(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false) );
    }
//    @ExceptionHandler(ElementsAlreadyExistsException.class)
//    public ResponseEntity<Rapport>handleElementAlreadyExists(ElementsAlreadyExistsException e, HttpServletRequest request)
//    {
//        Rapport rapport= new Rapport(
//                e.getMessage(),
//                HttpStatus.BAD_REQUEST.value(),
//                request.getRequestURI()
//        );
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(rapport);
//    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RapportValidation>handleConstraint(ConstraintViolationException e,WebRequest request){
        RapportValidation rv= new RapportValidation("Constraintes invalidées",HttpStatus.BAD_REQUEST.value(), request.getDescription(false));
        for (ConstraintViolation<?> constraintViolation:e.getConstraintViolations()
             ) {
           rv.addError(true, constraintViolation.getMessage());

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rv);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        RapportValidation rpv=new RapportValidation("Erreur de validation", HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false));
        for (ObjectError globalError:e.getBindingResult().getGlobalErrors()
             ) {
            rpv.addError(true,globalError.getDefaultMessage());
        }

        for (FieldError error:e.getBindingResult().getFieldErrors()) {
            rpv.addError(false,error.getField() +"-"+error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpv);
        }

/*
            StringBuilder builder=new StringBuilder();

            if(e.getGlobalErrorCount()>0) {

                builder.append("global errors---------------------------");
                for (ObjectError globalError: e.getBindingResult().getGlobalErrors()) {
                    builder.append("\n")
                            .append(globalError.getObjectName())
                            .append("-")
                            .append(globalError.getDefaultMessage())
                            .append("\n");

                }
                builder.append("\n") ;
            }
            if(e.getFieldErrorCount()>0) {
                builder.append("field errors----------------------------");

                for (FieldError fieldError: e.getBindingResult().getFieldErrors()){
                    builder.append("\n")
                            .append(fieldError.getField())
                            .append("-")
                            .append(fieldError.getDefaultMessage());

                }
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(builder.toString());
        }
*/
    }



