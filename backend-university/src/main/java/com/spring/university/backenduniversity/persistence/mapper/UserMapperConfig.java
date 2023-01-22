package com.spring.university.backenduniversity.persistence.mapper;

import com.spring.university.backenduniversity.persistence.dto.UserDTO;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface UserMapperConfig {
    void mapUser(User user, @MappingTarget UserDTO userDTO);
}
