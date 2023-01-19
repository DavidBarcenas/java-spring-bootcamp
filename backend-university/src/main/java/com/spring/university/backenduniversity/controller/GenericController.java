package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.DAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController <E, S extends DAO<E>> {
    protected final S service;
    protected String entityName;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E> getAll() {
        List<E> list = (List<E>) service.findAll();
        if(list.isEmpty()){
            throw new BadRequestException("No results found");
        }
        return list;
    }
}
