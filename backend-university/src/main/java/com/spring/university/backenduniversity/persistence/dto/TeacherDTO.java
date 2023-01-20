package com.spring.university.backenduniversity.persistence.dto;

import com.spring.university.backenduniversity.persistence.entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO extends UserDTO {
    private BigDecimal salary;

    public TeacherDTO(Integer id, String name, String lastName, String idDocument, Address address, BigDecimal salary) {
        super(id, name, lastName, idDocument, address);
        this.salary = salary;
    }
}
