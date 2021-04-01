package com.example.CorrectionExo1.exception;

public class ElementNotFoundException extends Exception{
    private Object id;
    public ElementNotFoundException(Object id) {
        super("L'element d'id "+id+" en question n'a pas été trouvé");
    }
}
