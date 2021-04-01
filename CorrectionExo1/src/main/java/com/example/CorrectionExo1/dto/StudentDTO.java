package com.example.CorrectionExo1.dto;

import com.example.CorrectionExo1.contraints.OldTimeResults;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@OldTimeResults
public class StudentDTO implements IdentifiedDTO<Integer>{
    @NotNull
    Integer id;

  @NotBlank
 // @Size(min = 2, max=20)

    String firstName;

 //@NotEmpty
    String lastName;

@PastOrPresent
    LocalDateTime birthDate;


    String login;
 @NotNull
          @Min(0) @Max(20)
    Integer result;

    SmallSectionDTO section;

  @NotNull
    String courseId;
}
