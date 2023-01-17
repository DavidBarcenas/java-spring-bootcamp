package com.spring.university.backenduniversity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FirstRestController {
    @GetMapping
    public String helloWorld() {
        return "Hello World 😀";
    }
}
