package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TestDAO {
    public abstract void addTest(Test test);
    public abstract void modifyTest(Test test);
    public abstract Optional<Test> viewTest(int testId);
    public abstract List<Test> viewTest();
    public abstract void deleteTest(int testId);
}
