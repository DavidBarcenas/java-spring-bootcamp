package com.spring.university.backenduniversity.persistence.dto;

import com.spring.university.backenduniversity.persistence.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDTO {
    private Integer id;
    private String name;
    private String lastName;
    @Size(min = 1, max = 10)
    private String idDocument;
    private Address address;
}
