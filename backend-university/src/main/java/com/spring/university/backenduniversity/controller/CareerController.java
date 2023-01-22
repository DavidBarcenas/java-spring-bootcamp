package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.mapper.CareerMapper;
import com.spring.university.backenduniversity.persistence.dto.CareerDTO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/careers")
@Api(value = "actions to manage the careers", tags="Career actions")
public class CareerController extends GenericController<Career, CareerDAO> {

    Logger logger = LoggerFactory.getLogger(CareerController.class);
    @Autowired
    private CareerMapper mapper;

    public CareerController(CareerDAO careerDAO) {
        super(careerDAO);
        entityName = "Career";
    }

    @GetMapping("/all")
    @ApiOperation(value = "Consult all the careers")
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

        logger.info("/all");

        return ResponseEntity.ok(message);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a career")
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
