package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CareerCommands implements CommandLineRunner {
    private final CareerDAO careerService;

    public CareerCommands(CareerDAO careerService) {
        this.careerService = careerService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Career engSystems = new Career(null, "Engineering systems", 20, 5);
        Career save = careerService.save(engSystems);
        System.out.println(save.toString());*/

        Optional<Career> oCareer = careerService.findById(1);
        if (oCareer.isPresent()) {
            Career career = oCareer.get();
            System.out.println(career.toString());
        } else {
            System.out.println("Career nto found");
        }
    }
}
