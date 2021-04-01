package com.example.CorrectionExo1.service;

import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;

import java.util.List;

public interface CrudSerivce<DTO, ID> {
    //Create
    void insert(DTO toInsert)throws ElementsAlreadyExistsException;
    //Read
    DTO getOne(ID id) throws ElementNotFoundException;
    List<DTO> getAll();
    //update
    void update(DTO toUpdate, ID id)throws ElementNotFoundException;
    //Delete
  void delete(ID id)throws ElementNotFoundException ;
}
