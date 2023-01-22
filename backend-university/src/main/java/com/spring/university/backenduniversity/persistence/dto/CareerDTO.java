package com.spring.university.backenduniversity.persistence.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CareerDTO {
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 80)
    private String name;

    @Positive(message = "The value cannot be negative")
    private Integer totalSubjects;

    @Positive(message = "The value cannot be negative")
    private Integer totalYears;
}