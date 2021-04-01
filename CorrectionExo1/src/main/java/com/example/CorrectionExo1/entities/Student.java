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
public class Student {
    @Id
    @Column(name="student_id")
    int id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="birth_date")
    LocalDateTime birthDate;

    String login;

    @Column(name ="year_result", nullable = false)
    int result;

    @ManyToOne
    @JoinColumn(name ="section_id")
    Section section;

    @Column(name = "course_id" ,nullable = false)
    String courseId;

}
