package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.SectionDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<DTO,ID> {
    // create
    ResponseEntity<DTO> create(DTO dto) throws ElementsAlreadyExistsException, ElementNotFoundException;
    //rea
    ResponseEntity<DTO> getOne(ID id) throws ElementNotFoundException;
    List<DTO> getAll();
    //update
    ResponseEntity<DTO> update(DTO dto, ID id) throws ElementNotFoundException;
    //delete
    ResponseEntity<DTO> delete(ID id) throws ElementNotFoundException;
}
