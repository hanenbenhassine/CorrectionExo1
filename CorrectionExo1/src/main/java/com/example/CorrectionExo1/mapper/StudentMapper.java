package com.example.CorrectionExo1.mapper;

import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.entities.Student;
import com.example.CorrectionExo1.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<StudentDTO, Student> {
    @Autowired
    private SmallSectionMapper sectionMapper;
    @Autowired
    private SectionRepository repo;
//    public StudentMapper(Mapper<SectionDTO, Section> sectionMapper) {
//        this.sectionMapper = sectionMapper;
//    }

    @Override
    public StudentDTO toDTO(Student student) {
        if(student==null)return null;
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthDate(student.getBirthDate())
                .login(student.getLogin())
                .result(student.getResult())
                .courseId(student.getCourseId())
                .section(sectionMapper.toDTO(student.getSection()))
                .build();
    }

    @Override
    public Student toENTITY(StudentDTO dto) {
        if(dto==null) return null;
        return Student.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .login(dto.getLogin())
                .result(dto.getResult())
                .courseId(dto.getCourseId())
                .section(repo.getOne(dto.getSection().getId()))
                .build();
    }
}
