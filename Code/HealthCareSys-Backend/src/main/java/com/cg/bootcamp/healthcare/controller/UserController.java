package com.cg.bootcamp.healthcare.controller;

import com.cg.bootcamp.healthcare.dao.UserDao;
import com.cg.bootcamp.healthcare.exceptions.RecordNotFoundException;
import com.cg.bootcamp.healthcare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    @Autowired
    UserDao userDao;

    /**
     *
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> viewAllUser() {
        return userDao.viewAllUser();
    }

    /**
     * Get Http Request
     */
    @GetMapping("/find/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<User> viewUserById(@PathVariable("id") int userId) {
        Optional<User> findById = userDao.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                User user = findById.get();
                return new ResponseEntity<User>(user, HttpStatus.FOUND);
            } else {
                throw new RecordNotFoundException("No record found with the provided " + userId + " user Id.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete Http Request
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int userId) {
        Optional<User> findById = userDao.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                userDao.deleteUser(userId);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No user account with user Id " + userId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Put Http Request
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateDiagnosticCenter(@Valid @RequestBody User user, @PathVariable("id") int userId) {
        Optional<User> findById = userDao.viewUserById(userId);
        try {
            if (findById.isPresent()) {
                userDao.updateUser(user);
                return new ResponseEntity<User>(user, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No user account with user Id " + userId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
