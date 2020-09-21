package com.cg.bootcamp.healthcare.ControllerLayer;

import com.cg.bootcamp.healthcare.DAO.TestDAO;
import com.cg.bootcamp.healthcare.Entity_Model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(value = "http://localhost:4200")
public class TestController {
    @Autowired
    private TestDAO testDAO;

    @GetMapping("/all")
    public List<Test> viewAllTest(){
        return testDAO.viewTest();
    }

    @PostMapping("/addtest")
    public ResponseEntity<Test> addTest(@Valid @RequestBody Test test){
        testDAO.addTest(test);
        return new ResponseEntity("Test is created successfully", HttpStatus.CREATED);
    }
}
