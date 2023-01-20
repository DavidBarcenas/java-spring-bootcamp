package com.spring.university.backenduniversity.mapper;

import com.spring.university.backenduniversity.persistence.dto.CareerDTO;
import com.spring.university.backenduniversity.persistence.entity.Career;

public class CareerMapper {
    public static CareerDTO mapCareer(Career career) {
        CareerDTO dto = new CareerDTO();
        dto.setId(career.getId());
        dto.setName(career.getName());
        dto.setTotalYears(career.getTotalYears());
        dto.setTotalSubjects(career.getTotalSubjects());
        return dto;
    }
}
