package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.DAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericController <E, S extends DAO<E>> {
    protected final S service;
    protected String entityName;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Map<String, Object> message = new HashMap<>();
        List<E> list = (List<E>) service.findAll();

        if(list.isEmpty()){
            message.put("success", Boolean.FALSE);
            message.put("message", "No records found");
            return ResponseEntity.badRequest().body(message);
        }

        message.put("success", Boolean.TRUE);
        message.put("data", list);

        return ResponseEntity.ok(message);
    }
}
