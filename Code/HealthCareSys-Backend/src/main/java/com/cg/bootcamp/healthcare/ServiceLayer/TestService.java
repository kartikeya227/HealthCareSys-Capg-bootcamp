package com.cg.bootcamp.healthcare.ServiceLayer;

import com.cg.bootcamp.healthcare.DAO.TestDAO;
import com.cg.bootcamp.healthcare.DAO.TestRepository;
import com.cg.bootcamp.healthcare.Entity_Model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements TestDAO {
    @Autowired
    TestRepository testRepository;

    @Override
    public void addTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public void modifyTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public Optional<Test> viewTest(int testId) {
        return testRepository.findById(testId);
    }

    @Override
    public List<Test> viewTest() {
        return testRepository.findAll();
    }

    @Override
    public void deleteTest(int testId) {
        testRepository.deleteById(testId);
    }
}
