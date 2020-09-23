package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.Appointment;
import com.cg.bootcamp.healthcare.Entity_Model.DiagnosticCenter;

import java.util.List;
import java.util.Optional;

public interface AppointmentDao {
    public abstract void addAppointment(Appointment appointment);
    public abstract void deleteAppointment(int appointmentId);
    public abstract List<Appointment> viewAllAppointment();
    public abstract List<Appointment> viewAllAppointmentByUser(int userId);
    public abstract List<Appointment> viewAllAppointmentByDiagnosticCenter(int centerId);
    public abstract void updateAppointment(Appointment appointment );
    public abstract Optional<Appointment> findAppointment(int appointmentId);
    public abstract void approveAppointment(int appointmentId);

}
