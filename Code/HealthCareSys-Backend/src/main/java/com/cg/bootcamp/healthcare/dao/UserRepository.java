package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User WHERE username =?1 order by userId ASC ")
    User findByUsername(String username);
}
