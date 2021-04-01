package com.example.CorrectionExo1.mapper;

import com.example.CorrectionExo1.dto.SectionDTO;
import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.entities.Section;
import com.example.CorrectionExo1.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SectionMapper implements Mapper<SectionDTO, Section>{
    @Autowired
    private StudentSectionMapper sMapper;

//    public SectionMapper(Mapper<StudentDTO, Student> sMapper) {
//        this.sMapper = sMapper;
//    }

    @Override
    public SectionDTO toDTO(Section section) {
        if(section== null)
            return null;
        return SectionDTO.builder()
                .id(section.getId())
                .name(section.getName())
                .delegateId(section.getDelegateId())
                .students(section.getStudents().stream()
                        .map(sMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Section toENTITY(SectionDTO sectionDTO) {
        if(sectionDTO == null) return null;

        return Section.builder()
                .id(sectionDTO.getId())
                .name(sectionDTO.getName())
                .delegateId(sectionDTO.getDelegateId())

                .build();
    }
}
