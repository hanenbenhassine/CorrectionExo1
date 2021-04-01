package com.example.CorrectionExo1.mapper;

public interface Mapper <DTO,ENTITY>{
    DTO toDTO(ENTITY entity);
    ENTITY toENTITY(DTO dto);
}
