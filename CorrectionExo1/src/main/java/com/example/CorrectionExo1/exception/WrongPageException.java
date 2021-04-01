package com.example.CorrectionExo1.exception;

public class WrongPageException extends Exception{
    private int searchedPage;
    private int maxPageNbr;

    public WrongPageException(int searchedPage, int maxPageNbr) {
        super("La page rechercher {"+searchedPage+"}n'exsite pas, la derniere page disponible actuellement est :"+maxPageNbr);
        this.searchedPage = searchedPage;
        this.maxPageNbr = maxPageNbr;
    }
}
