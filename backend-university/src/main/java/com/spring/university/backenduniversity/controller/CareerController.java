package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.mapper.CareerMapper;
import com.spring.university.backenduniversity.persistence.dto.CareerDTO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/careers")
public class CareerController extends GenericController<Career, CareerDAO> {
    @Autowired
    private CareerMapper mapper;

    public CareerController(CareerDAO careerDAO) {
        super(careerDAO);
        entityName = "Career";
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDTO() {
        Map<String, Object> message = new HashMap<>();
        List<Career> careers = (List<Career>) service.findAll();

        if(careers.isEmpty()){
            message.put("success", Boolean.FALSE);
            message.put("message", "No records found");
            return ResponseEntity.badRequest().body(message);
        }

        List<CareerDTO> careersDTO = careers.stream().map(mapper::mapCareer).toList();

        message.put("success", Boolean.TRUE);
        message.put("data", careersDTO);

        return ResponseEntity.ok(message);
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
