package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.IdentifiedDTO;
import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.service.CrudSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudController<DTO extends IdentifiedDTO<ID>,ID>implements CrudController<DTO,ID> {
    protected final CrudSerivce<DTO,ID>service;

    protected AbstractCrudController(CrudSerivce<DTO, ID> service) {
        this.service = service;
    }


    @Override

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementNotFoundException {

            return ResponseEntity.ok(service.getOne(id));

    }

    @Override
    @GetMapping
    public List<DTO> getAll() {
        return service.getAll();
    }
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@Valid @RequestBody DTO dto, @PathVariable("id") ID id) throws ElementNotFoundException {



            service.update(dto,id);
            return ResponseEntity.ok(service.getOne(id));

    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementNotFoundException {

           DTO dto=service.getOne(id);
            service.delete(id);
            return ResponseEntity.ok(dto);


    }
    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<DTO> create(@Valid @RequestBody DTO dto) throws ElementsAlreadyExistsException, ElementNotFoundException {

            service.insert(dto);
            return ResponseEntity.ok(service.getOne(dto.getId())) ;

    }
}
