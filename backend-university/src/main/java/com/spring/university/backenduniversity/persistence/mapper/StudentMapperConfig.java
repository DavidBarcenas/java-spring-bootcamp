package com.spring.university.backenduniversity.persistence.mapper;

import com.spring.university.backenduniversity.persistence.dto.StudentDTO;
import com.spring.university.backenduniversity.persistence.entity.Student;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface StudentMapperConfig extends UserMapperConfig {
    @InheritConfiguration(name = "mapUser")
    void mapStudent(Student student, @MappingTarget StudentDTO studentDTO);
}
