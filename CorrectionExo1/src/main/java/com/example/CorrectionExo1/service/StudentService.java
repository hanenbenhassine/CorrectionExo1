package com.example.CorrectionExo1.service;

import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.entities.Student;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.mapper.Mapper;
import com.example.CorrectionExo1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements CrudSerivce<StudentDTO, Integer>{
    private final StudentRepository repo;
    private final Mapper<StudentDTO, Student>studentMapper;


    public StudentService(StudentRepository repo, Mapper<StudentDTO, Student> studentMapper) {
        this.repo = repo;
        this.studentMapper = studentMapper;
    }

    @Override
    public void insert(StudentDTO toInsert) throws ElementsAlreadyExistsException {
        if(toInsert==null)throw new IllegalArgumentException();
        if(repo.existsById(toInsert.getId()))throw new ElementsAlreadyExistsException();
        Student s=studentMapper.toENTITY(toInsert);
        repo.save(s);

    }

    @Override
    public StudentDTO getOne(Integer id) throws ElementNotFoundException {
        if(id==null)throw new IllegalArgumentException();
        Student entity= repo.findById(id).orElseThrow(()->new ElementNotFoundException(id));
        return studentMapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<StudentDTO> getAll() {
        return repo.findAll()
                .stream()
                .map( studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(StudentDTO toUpdate, Integer id) throws ElementNotFoundException {
        if(toUpdate==null || id==null)throw new IllegalArgumentException();
        Student entity= repo.findById(id).orElseThrow(()->new ElementNotFoundException(id));
       Student s=studentMapper.toENTITY(toUpdate);
       entity.setFirstName(s.getFirstName());
       entity.setLastName(s.getLastName());
       entity.setBirthDate(s.getBirthDate());
       entity.setLogin(s.getLogin());
       entity.setResult(s.getResult());
       entity.setCourseId(s.getCourseId());
       entity.setSection(s.getSection());

    }

    @Override
    public void delete(Integer id) throws ElementNotFoundException {
    if(id==null)throw new IllegalArgumentException();
    if(!repo.existsById(id)) throw  new ElementNotFoundException(id);
        repo.deleteById(id);
    }
}
