package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
}
