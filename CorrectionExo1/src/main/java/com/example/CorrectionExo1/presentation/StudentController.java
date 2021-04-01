package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.service.CrudSerivce;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/student")
@Profile("api")
public class StudentController extends AbstractCrudController<StudentDTO,Integer> {

    protected StudentController(CrudSerivce<StudentDTO, Integer> service) {
        super(service);
    }


/*
    @Override
    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO) {
        try {
            service.insert(studentDTO);
           return ResponseEntity.ok(service.getOne(studentDTO.getId())) ;
        } catch (ElementsAlreadyExistsException | ElementNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getOne(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getOne(id));
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @Override
    @GetMapping
    public List<StudentDTO> getAll() {

        return service.getAll();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO,@PathVariable Integer id) {

        try {

            service.update(studentDTO,id);
            return ResponseEntity.ok(service.getOne(id));
        } catch (ElementNotFoundException e) {
      return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<StudentDTO> delete(@PathVariable Integer id) {
        StudentDTO dto=null;
        try {
            dto=service.getOne(id);
            service.delete(id);
            return ResponseEntity.ok(dto);
        } catch (ElementNotFoundException e) {

          return ResponseEntity.notFound().build();
        }

    }
*/
}
