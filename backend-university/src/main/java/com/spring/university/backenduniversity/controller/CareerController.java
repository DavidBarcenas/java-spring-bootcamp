package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {
    @Autowired
    private final CareerDAO careerDAO;

    public CareerController(CareerDAO careerDAO) {
        this.careerDAO = careerDAO;
    }

    @GetMapping
    public List<Career> getAll() {
        List<Career> careers = (List<Career>) careerDAO.findAll();
        if(careers.isEmpty()) {
            throw new BadRequestException("No results found");
        }
        return careers;
    }
}
