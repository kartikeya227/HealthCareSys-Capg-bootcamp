package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> viewUserById(int userId);

    List<User> viewAllUser();

    void updateUser(User user);

    void deleteUser(int userId);
}
