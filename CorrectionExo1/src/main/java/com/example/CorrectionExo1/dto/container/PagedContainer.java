package com.example.CorrectionExo1.dto.container;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter@Setter
public class PagedContainer <T>{
    private List<T> elements;
    private Integer nbrPage;
    private Integer nbrElement;
    private Integer page;
    private String nextPage;
    private String previousPage;

    public PagedContainer(List<T> elements, Integer nbrPage, Integer nbrElement, Integer page) {
        this.elements = elements;
        this.nbrPage = nbrPage;
        this.nbrElement = nbrElement;
        this.page = page;


    }
}
