package com.example.CorrectionExo1.mapper;

import com.example.CorrectionExo1.dto.StudentSectionDTO;
import com.example.CorrectionExo1.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentSectionMapper  {


    public StudentSectionDTO toDTO(Student entity) {
        if(entity==null)
        return null;
        return StudentSectionDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }


}
