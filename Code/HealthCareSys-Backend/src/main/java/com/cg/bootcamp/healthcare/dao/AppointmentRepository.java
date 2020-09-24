package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("FROM Appointment WHERE user.userId = ?1 order by appointmentId ASC ")
    List<Appointment> findAllAppointmentByUser(int User_Id);

    @Query("FROM Appointment WHERE diagnosticCenter.centerId =?1 order by appointmentId ASC ")
    List<Appointment> findAllAppointmentByDiagnosticCenter(int centerId);
}
