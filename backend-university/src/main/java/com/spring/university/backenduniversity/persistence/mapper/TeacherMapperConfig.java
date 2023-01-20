package com.spring.university.backenduniversity.persistence.mapper;

import com.spring.university.backenduniversity.persistence.dto.TeacherDTO;
import com.spring.university.backenduniversity.persistence.entity.Teacher;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface TeacherMapperConfig extends UserMapperConfig {
    @InheritConfiguration(name = "mapUser")
    void mapTeacher(Teacher teacher, @MappingTarget TeacherDTO teacherDTO);
}
