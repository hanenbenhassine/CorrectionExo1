package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.SectionDTO;
import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.service.CrudSerivce;
import com.example.CorrectionExo1.service.SectionService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
@Profile("api")
public class SectionController extends AbstractCrudController<SectionDTO,Integer> {


    protected SectionController(CrudSerivce<SectionDTO, Integer> service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity <SectionDTO>create(@RequestBody SectionDTO dto) {
        try {
            service.insert(dto);
            HttpHeaders headers= new HttpHeaders();
            headers.add("fromController","SectionController");
            headers.add("fromController","SectionController2");
            return new ResponseEntity<SectionDTO>(
                    dto,
                    headers,
                    HttpStatus.CREATED
            );
        } catch (ElementsAlreadyExistsException e) {
            e.printStackTrace();
        }
        return  null;
    }
/*

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> getOne(@PathVariable("id") Integer integer) {
        try {
            return ResponseEntity.ok(serivce.getOne(integer));
        } catch (ElementNotFoundException e) {
           return ResponseEntity.status(404).build();
        }
    }

    @Override
    @GetMapping
    public List<SectionDTO> getAll() {

        return serivce.getAll();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SectionDTO> update(@RequestBody SectionDTO dto, @PathVariable("id") Integer integer) {
        try {
            serivce.update(dto,integer);
        return   ResponseEntity.ok( serivce.getOne(integer));
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(404).build();
        }

    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<SectionDTO> delete(@PathVariable("id") Integer integer) {

        try {
            SectionDTO dto =serivce.getOne(integer);
            serivce.delete(integer);
            return ResponseEntity.ok(dto);
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }
*/
    @GetMapping("/students/{id}")
    public ResponseEntity<List<StudentDTO>>getStudentFromSection(@PathVariable("id") Integer id) throws ElementNotFoundException {
       List<StudentDTO>studentDTO= ((SectionService)service).getStudentsBySectionId(id);
       return ResponseEntity.ok(studentDTO);
    }
}
