package com.example.CorrectionExo1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentSectionDTO {
    Integer id;
    String firstName;
    String lastName;
}
