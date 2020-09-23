package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.DiagnosticCenter;

import java.util.List;
import java.util.Optional;

public interface DiagnosticCenterDao {
    public abstract void addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
    public abstract void deleteDiagnosticCenter(int centerId);
    public abstract List<DiagnosticCenter> viewAllDiagnosticCenter();
    public abstract void updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
    public abstract Optional<DiagnosticCenter> findDiagnosticCenter(int centerId);
}
