package com.cg.bootcamp.healthcare.service;

import com.cg.bootcamp.healthcare.dao.UserDao;
import com.cg.bootcamp.healthcare.dao.UserRepository;
import com.cg.bootcamp.healthcare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> viewUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> viewAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
