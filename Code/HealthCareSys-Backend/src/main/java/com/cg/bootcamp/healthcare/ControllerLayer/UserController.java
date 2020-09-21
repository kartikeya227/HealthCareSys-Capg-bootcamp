package com.cg.bootcamp.healthcare.ControllerLayer;

import com.cg.bootcamp.healthcare.DAO.UserDao;
import com.cg.bootcamp.healthcare.Entity_Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/all")
    public List<User> viewAllUser(){
        return userDao.viewAllUser();
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        userDao.addUser(user);
        return new ResponseEntity("has been successfully created!", HttpStatus.CREATED);
    }
}
