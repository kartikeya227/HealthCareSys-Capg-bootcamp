package com.cg.bootcamp.healthcare.dao;

import com.cg.bootcamp.healthcare.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentDao {
    String addAppointment(Appointment appointment);

    void deleteAppointment(int appointmentId);

    List<Appointment> viewAllAppointment();

    List<Appointment> viewAllAppointmentByUser(int userId);

    List<Appointment> viewAllAppointmentByDiagnosticCenter(int centerId);

    void updateAppointment(Appointment appointment);

    Optional<Appointment> findAppointment(int appointmentId);

    void approveAppointment(int appointmentId);

}
