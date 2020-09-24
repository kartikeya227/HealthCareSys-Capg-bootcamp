package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.DiagnosticCenter;

import java.util.List;
import java.util.Optional;

public interface DiagnosticCenterDao {
    void addDiagnosticCenter(DiagnosticCenter diagnosticCenter);

    void deleteDiagnosticCenter(int centerId);

    List<DiagnosticCenter> viewAllDiagnosticCenter();

    void updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);

    Optional<DiagnosticCenter> findDiagnosticCenter(int centerId);
}
