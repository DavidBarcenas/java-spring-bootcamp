package com.spring.university.backenduniversity.mapper;

import com.spring.university.backenduniversity.persistence.dto.CareerDTO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareerMapper {
    CareerDTO mapCareer(Career career);
}
