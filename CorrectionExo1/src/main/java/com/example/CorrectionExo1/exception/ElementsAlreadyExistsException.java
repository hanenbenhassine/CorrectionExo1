package com.example.CorrectionExo1.exception;

public class ElementsAlreadyExistsException extends Exception{
    public ElementsAlreadyExistsException() {
        super("L'element exst déjà dans la DB.");
    }
}
