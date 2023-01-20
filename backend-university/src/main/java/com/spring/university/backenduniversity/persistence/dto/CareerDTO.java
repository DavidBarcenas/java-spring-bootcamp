package com.spring.university.backenduniversity.persistence.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CareerDTO {
    private Integer id;
    private String name;
    private Integer totalSubjects;
    private Integer totalYears;
}