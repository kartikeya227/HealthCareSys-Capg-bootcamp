package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TestRepository")
public interface TestRepository extends JpaRepository<Test, Integer> {
}
