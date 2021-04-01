package com.example.CorrectionExo1.dto;

import com.example.CorrectionExo1.contraints.Multiple4;
import com.example.CorrectionExo1.contraints.Waged;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Waged
public class ProfessorDTO implements IdentifiedDTO<Integer>{
    @NotNull
    Integer id;
    @NotNull
    @Size(min = 3)
    String name;
    @NotNull
    @Size(min = 3)
    String surname;
    @NotNull
    @Min(100)@Max(999)
    @Multiple4
    Integer office;
    @NotNull
    @Email
    String  email;
    @NotNull
    @PastOrPresent
    LocalDateTime hireDate;
    @NotNull
    @Min(1500)
    Integer wage;
    @NotNull
    SmallSectionDTO section;
}
