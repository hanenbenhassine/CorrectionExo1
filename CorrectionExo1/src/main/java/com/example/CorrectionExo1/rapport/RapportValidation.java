package com.example.CorrectionExo1.rapport;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class RapportValidation extends Rapport {
    private final List<String> globalErrors = new ArrayList<>();
    private final List<String>fieldErrors = new ArrayList<>();

    public RapportValidation(String message, int code, String chemin) {
        super(message, code, chemin);
    }
    public void addError(boolean global,String error){
        if(global)
            globalErrors.add(error);
        else
            fieldErrors.add(error);
    }

    public List<String> getGlobalErrors() {
        return new ArrayList<>(this.globalErrors);
    }

    public List<String> getFieldErrors() {
        return new ArrayList<>(this.fieldErrors);
    }
}

