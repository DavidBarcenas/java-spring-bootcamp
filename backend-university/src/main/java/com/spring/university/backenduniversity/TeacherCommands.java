package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.dao.TeacherDAO;
import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Teacher;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class TeacherCommands implements CommandLineRunner {
    private final CareerDAO careerService;
    private final TeacherDAO teacherService;

    public TeacherCommands(CareerDAO careerService, TeacherDAO teacherService) {
        this.careerService = careerService;
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Career career = null;
        Optional<Career> oCareer = careerService.findById(2);

        if (oCareer.isPresent()) {
            career = oCareer.get();
            System.out.println(career.toString());
        } else {
            System.out.println("Career not found");
        }

        Set<Career> listOfCareers = new HashSet<Career>();
        listOfCareers.add(career);

        Teacher teacher1 = new Teacher(null, "Romina", "Sanchez", "asdasd34",
           new Address("Calle 4", "678", "09876", null, null, "México"),
           new BigDecimal(23000));

        Optional<User> oTeacher1 = teacherService.findById(7);
        User teacher1 = null;

        if (oTeacher1.isPresent()) {
            teacher1 = oTeacher1.get();
            ((Teacher) teacher1).setCareers(listOfCareers);
            teacherService.save(teacher1);
        }


        Iterable<User> teachers = teacherService.findTeachersByCareer("Systems Engineering");
        teachers.forEach(System.out::println);*/
    }
}
