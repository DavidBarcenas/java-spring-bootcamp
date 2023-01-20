package com.spring.university.backenduniversity.persistence.mapper;

import com.spring.university.backenduniversity.persistence.dto.StudentDTO;
import com.spring.university.backenduniversity.persistence.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = StudentMapperConfig.class)
public abstract class StudentMapper {
    public abstract StudentDTO mapStudentDTO(Student student);
    public abstract Student mapStudent(StudentDTO studentDTO);
}
