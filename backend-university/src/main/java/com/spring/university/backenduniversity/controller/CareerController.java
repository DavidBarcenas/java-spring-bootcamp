package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Career getById(@PathVariable Integer id) {
        Optional<Career> career = careerDAO.findById(id);
        if(career.isEmpty()){
            throw new BadRequestException(String.format("The career with id %d does not exist", id));
        }
        return career.get();
    }

    @PostMapping
    public Career createCareer(@RequestBody Career career) {
        return careerDAO.save(career);
    }
}
