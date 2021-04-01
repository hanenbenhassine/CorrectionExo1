package com.example.CorrectionExo1.rapport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Rapport {
    String message;
    int code;
    String chemin;

    public Rapport(String message, int code, String chemin) {
        this.message = message;
        this.code = code;
        this.chemin = chemin;
    }
}
