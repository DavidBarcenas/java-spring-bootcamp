package com.spring.university.backenduniversity.persistence.dto;

import com.spring.university.backenduniversity.persistence.entity.Address;

public class StudentDTO extends UserDTO {
    public StudentDTO(Integer id, String name, String lastName, String idDocument, Address address) {
        super(id, name, lastName, idDocument, address);
    }
}
