package com.cg.bootcamp.healthcare.ServiceLayer;

import com.cg.bootcamp.healthcare.DAO.DiagnosticCenterDao;
import com.cg.bootcamp.healthcare.DAO.DiagnosticCenterRepository;
import com.cg.bootcamp.healthcare.Entity_Model.DiagnosticCenter;
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
