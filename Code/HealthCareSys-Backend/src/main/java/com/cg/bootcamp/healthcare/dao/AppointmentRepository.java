package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    /**
     * Find all the appointment by a particular user id, (appointments made by a particular user).
     * Uses User Id to search. User Id acts a FK between USER and APPOINTMENT table.
     */
    @Query("FROM Appointment WHERE user.userId = ?1 order by appointmentId ASC ")
    List<Appointment> findAllAppointmentByUser(int User_Id);

    /**
     * Find all the appointment under a particular diagnostic center.
     * Uses Center Id to search. Center Id acts as a FK between DIAGNOSTIC CENTER and  APPOINTMENT table.
     */
    @Query("FROM Appointment WHERE diagnosticCenter.centerId =?1 order by appointmentId ASC ")
    List<Appointment> findAllAppointmentByDiagnosticCenter(int centerId);
}
