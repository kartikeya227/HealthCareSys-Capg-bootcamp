package com.cg.bootcamp.healthcare.service;

import com.cg.bootcamp.healthcare.dao.DiagnosticCenterDao;
import com.cg.bootcamp.healthcare.dao.DiagnosticCenterRepository;
import com.cg.bootcamp.healthcare.model.DiagnosticCenter;
import com.cg.bootcamp.healthcare.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticCenterService implements DiagnosticCenterDao {

    @Autowired
    DiagnosticCenterRepository diagnosticCenterRepository;

    @Override
    public void addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
        Test t1 = new Test();
        t1.setTestDoctor("Dr. Raj");
        t1.setTestName("Blood Test Basic");
        Test t2 = new Test();
        t2.setTestDoctor("Dr. Rahul");
        t2.setTestName("Dental Test Basic");
        Test t3 = new Test();
        t3.setTestDoctor("Dr. Rajesh");
        t3.setTestName("Eye Test Basic");

        List<Test> test = diagnosticCenter.getTestList();

        test.add(t1);
        test.add(t2);
        test.add(t3);

        diagnosticCenter.setTestList(test);


        diagnosticCenterRepository.save(diagnosticCenter);
    }

    @Override
    public void deleteDiagnosticCenter(int centerId) {
        diagnosticCenterRepository.deleteById(centerId);
    }

    @Override
    public List<DiagnosticCenter> viewAllDiagnosticCenter() {
        return diagnosticCenterRepository.findAll();
    }

    @Override
    public void updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
        diagnosticCenterRepository.save(diagnosticCenter);
    }

    @Override
    public Optional<DiagnosticCenter> findDiagnosticCenter(int centerId) {
        return diagnosticCenterRepository.findById(centerId);
    }
}
