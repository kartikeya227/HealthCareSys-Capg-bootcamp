package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.DiagnosticCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DiagnosticCenterRepository")
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {
}