package com.example.CorrectionExo1.service;

import com.example.CorrectionExo1.dto.ProfessorDTO;
import com.example.CorrectionExo1.entities.Professor;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.mapper.Mapper;
import com.example.CorrectionExo1.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService implements CrudSerivce<ProfessorDTO,Integer> {
    private final Mapper<ProfessorDTO, Professor>mapper;
    private final ProfessorRepository repo;

    public ProfessorService(Mapper<ProfessorDTO, Professor> mapper, ProfessorRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public void insert(ProfessorDTO toInsert) throws ElementsAlreadyExistsException {
        if(toInsert==null)throw new IllegalArgumentException();
        if(repo.existsById(toInsert.getId()))
            throw new ElementsAlreadyExistsException();
        repo.save(mapper.toENTITY(toInsert));

    }

    @Override
    public ProfessorDTO getOne(Integer id) throws ElementNotFoundException {
        if(id==null)throw  new  IllegalArgumentException();

        return repo.findById(id).map(mapper::toDTO)
                .orElseThrow(()->new ElementNotFoundException(id));
    }

    @Override
    public List<ProfessorDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ProfessorDTO toUpdate, Integer id) throws ElementNotFoundException {
        if(toUpdate==null || id==null)throw new IllegalArgumentException();
        Professor p=mapper.toENTITY(toUpdate);
        Professor prof=repo.findById(id)
                .orElseThrow(()->new ElementNotFoundException(id));
        prof.setEmail(p.getEmail());
        prof.setHiredate(p.getHiredate());
        prof.setName(p.getName());
        prof.setSection(p.getSection());

        prof.setOffice(p.getOffice());
        prof.setSurname(p.getSurname());
        prof.setWage(p.getWage());
        repo.save(prof);


    }

    @Override
    public void delete(Integer id) throws ElementNotFoundException {
        if(id==null)throw new IllegalArgumentException();
        if(!repo.existsById(id)) throw new ElementNotFoundException(id);
        repo.deleteById(id);

    }
}
