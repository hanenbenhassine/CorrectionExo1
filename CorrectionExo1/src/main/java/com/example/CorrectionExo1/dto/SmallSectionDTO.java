package com.example.CorrectionExo1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SmallSectionDTO {
    private Integer id;
    private String name;
}
