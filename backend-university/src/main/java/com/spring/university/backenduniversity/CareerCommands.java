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
        Career systemsEng = new Career(null, "Systems Engineering", 60, 5);
        Career foodEng = new Career(null, "Food Engineering", 40, 3);
        Career industryEng = new Career(null, "Industry Engineering", 30, 6);
        Career electronicEng = new Career(null, "Electronic Engineering", 80, 8);
        Career travel = new Career(null, "Travel", 20, 2);
        Career Yoga = new Career(null, "Yoga", 10, 1);

        careerService.save(systemsEng);
        careerService.save(foodEng);
        careerService.save(industryEng);
        careerService.save(electronicEng);
        careerService.save(travel);
        careerService.save(Yoga);
    }
}
