package com.spring.university.backenduniversity.persistence.dto;


import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO extends UserDTO {
    private BigDecimal salary;
    private EmployeeType employeeType;

    public EmployeeDTO(Integer id, String name, String lastName, String idDocument, Address address, BigDecimal salary, EmployeeType employeeType) {
        super(id, name, lastName, idDocument, address);
        this.salary = salary;
        this.employeeType = employeeType;
    }
}
