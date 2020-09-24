package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.DiagnosticCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DiagnosticCenterRepository")
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {
}