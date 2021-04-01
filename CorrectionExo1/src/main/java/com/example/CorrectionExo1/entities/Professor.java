package com.example.CorrectionExo1.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Professor {
    @Id
    @Column(name = "professor_id")
    int id;
    @Column(name = "professor_name")

    String name;

    @Column(name = "professor_surname")
    String surname;


    @Column(name = "professor_office")

    int office;
    @Column(name = "professor_email")

    String email;
    @Column(name = "professor_hire_date")

    LocalDateTime hiredate;
    @Column(name = "professor_wage")

    int wage;
    @ManyToOne
    @JoinColumn(name = "section_id")
    Section section;


}
