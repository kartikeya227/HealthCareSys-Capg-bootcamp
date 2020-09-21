package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public abstract void addUser(User user);
    public abstract Optional<User> viewUserById(int userId);
    public abstract List<User> viewAllUser();
    public abstract void updateUser(User user);
    public abstract void deleteUser(int userId);
}
