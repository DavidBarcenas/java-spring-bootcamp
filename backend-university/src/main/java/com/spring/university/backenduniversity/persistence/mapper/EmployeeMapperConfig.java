package com.spring.university.backenduniversity.persistence.mapper;

import com.spring.university.backenduniversity.persistence.dto.EmployeeDTO;
import com.spring.university.backenduniversity.persistence.entity.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface EmployeeMapperConfig extends UserMapperConfig {
    @InheritConfiguration(name = "mapUser")
    void mapEmployee(Employee employee, @MappingTarget EmployeeDTO employeeDTO);
}
