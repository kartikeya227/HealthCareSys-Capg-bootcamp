package com.cg.bootcamp.healthcare.ServiceLayer;

import com.cg.bootcamp.healthcare.DAO.UserDao;
import com.cg.bootcamp.healthcare.DAO.UserRepository;
import com.cg.bootcamp.healthcare.Entity_Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

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
