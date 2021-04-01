package com.example.CorrectionExo1.mapper;

import com.example.CorrectionExo1.dto.SmallSectionDTO;
import com.example.CorrectionExo1.entities.Section;
import org.springframework.stereotype.Component;

@Component
public class SmallSectionMapper {
    SmallSectionDTO toDTO(Section entity){
        if(entity==null)
            return null;
        return SmallSectionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
