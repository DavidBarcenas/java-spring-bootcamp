package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/careers")
public class CareerController extends GenericController<Career, CareerDAO> {
    public CareerController(CareerDAO careerDAO) {
        super(careerDAO);
        entityName = "Career";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Career career) {
        Map<String, Object> message = new HashMap<>();
        Career newCareer = null;
        Optional<Career> prevCareer = service.findById(id);

        if(prevCareer.isEmpty()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("The career with id %d does not exist", id));
            return ResponseEntity.badRequest().body(message);
        }

        newCareer = prevCareer.get();
        newCareer.setTotalYears(career.getTotalYears());
        newCareer.setTotalSubjects(career.getTotalSubjects());

        message.put("success", Boolean.TRUE);
        message.put("data", service.save(newCareer));
        return ResponseEntity.ok(message);
    }
}
