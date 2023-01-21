package com.spring.university.backenduniversity.persistence.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.university.backenduniversity.persistence.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StudentDTO.class, name = "student"),
        @JsonSubTypes.Type(value = TeacherDTO.class, name = "teacher"),
        @JsonSubTypes.Type(value = EmployeeDTO.class, name = "employee"),
})
public abstract class UserDTO {
    private Integer id;
    private String name;
    private String lastName;
    @Size(min = 1, max = 10)
    private String idDocument;
    private Address address;
}
