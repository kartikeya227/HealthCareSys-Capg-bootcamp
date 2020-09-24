package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TestRepository")
public interface TestRepository extends JpaRepository<Test, Integer> {
}
