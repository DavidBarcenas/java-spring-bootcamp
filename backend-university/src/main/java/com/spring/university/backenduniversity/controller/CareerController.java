package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/careers")
public class CareerController extends GenericController<Career, CareerDAO> {
    public CareerController(CareerDAO careerDAO) {
        super(careerDAO);
        entityName = "Career";
    }

    @GetMapping("/{id}")
    public Career getById(@PathVariable Integer id) {
        Optional<Career> career = service.findById(id);
        if(career.isEmpty()){
            throw new BadRequestException(String.format("The career with id %d does not exist", id));
        }
        return career.get();
    }

    @PostMapping
    public Career create(@RequestBody Career career) {
        if(career.getTotalYears() < 0) {
            throw new BadRequestException("The number of years cannot be negative");
        }
        if(career.getTotalSubjects() < 0) {
            throw new BadRequestException("The amount of subjects cannot be negative");
        }
        return service.save(career);
    }

    @PutMapping("/{id}")
    public Career update(@PathVariable Integer id, @RequestBody Career career) {
        Career newCareer = null;
        Optional<Career> prevCareer = service.findById(id);
        if(prevCareer.isEmpty()) {
            throw new BadRequestException(String.format("The career with id %d does not exist", id));
        }
        newCareer = prevCareer.get();
        newCareer.setTotalYears(career.getTotalYears());
        newCareer.setTotalSubjects(career.getTotalSubjects());
        return service.save(newCareer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
