package com.example.CorrectionExo1.mapper;

import com.example.CorrectionExo1.dto.ProfessorDTO;
import com.example.CorrectionExo1.entities.Professor;
import com.example.CorrectionExo1.repository.SectionRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper implements Mapper<ProfessorDTO, Professor>{
    private final SmallSectionMapper mapper;
    private final SectionRepository repo;

    public ProfessorMapper(SmallSectionMapper mapper, SectionRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public ProfessorDTO toDTO(Professor professor) {
        if(professor==null)
        return null;
        return  ProfessorDTO.builder()
                .id(professor.getId())

                .name(professor.getName())
                .surname(professor.getSurname())
                .office(professor.getOffice())
                .email(professor.getEmail())
                .hireDate(professor.getHiredate())
                .section(mapper.toDTO(professor.getSection()))
                .wage(professor.getWage())
                .build();
    }

    @Override
    public Professor toENTITY(ProfessorDTO professorDTO) {
        if(professorDTO==null)
        return null;
        return Professor.builder()
                .id(professorDTO.getId())
                .name(professorDTO.getName())
                .surname(professorDTO.getSurname())
                .email(professorDTO.getEmail())
                .office(professorDTO.getOffice())
                .hiredate(professorDTO.getHireDate())
                .wage(professorDTO.getWage())
                .section(repo.getOne(professorDTO.getSection().getId()))
                .build();
    }
}
