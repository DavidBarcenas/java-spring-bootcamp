package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Student;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CareerCommands implements CommandLineRunner {
    private final CareerDAO careerService;
    private final StudentDAO studentService;

    public CareerCommands(CareerDAO careerService, StudentDAO studentService) {
        this.careerService = careerService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Career systemsEng = new Career(null, "Systems Engineering", 60, 5);
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

        List<Career> careers = (List<Career>) careerService.findByTotalYearsAfter(4);
        careers.forEach(System.out::println);*/


        /*Optional<Career> systemsEng = careerService.findById(2);
        Iterable<User> students = studentService.findAll();

        systemsEng.ifPresent(career -> students.forEach(student -> ((Student) student).setCareer(career)));
        students.forEach(studentService::save);

        Optional<User> student = studentService.findByNameAndLastName("David", "Barcenas");
        System.out.println(student.get());

        Optional<User> student2 = studentService.findByIdDocument("3456juyik");
        System.out.println(student2.get());

        List<User> students = (List<User>) studentService.findByLastName("Juarez");
        students.forEach(System.out::println);*/

        Iterable<Career> careers = careerService.findCareersByTeacherNameAndLastname("Heriberto", "Cruz");
        careers.forEach(System.out::println);
    }
}
