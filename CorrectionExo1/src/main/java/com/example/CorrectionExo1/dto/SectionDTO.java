package com.example.CorrectionExo1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectionDTO implements IdentifiedDTO<Integer>{
    private Integer id;
    private String name;
    private int delegateId;
    List<StudentSectionDTO>students;
}
