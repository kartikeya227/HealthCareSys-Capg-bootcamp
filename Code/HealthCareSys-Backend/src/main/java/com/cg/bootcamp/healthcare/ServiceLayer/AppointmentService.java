package com.cg.bootcamp.healthcare.ServiceLayer;

import com.cg.bootcamp.healthcare.DAO.AppointmentDao;
import com.cg.bootcamp.healthcare.DAO.AppointmentRepository;
import com.cg.bootcamp.healthcare.Entity_Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements AppointmentDao {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<Appointment> viewAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> viewAllAppointmentByUser(int userId) {
        return appointmentRepository.findAllAppointmentByUser(userId);
    }

    @Override
    public List<Appointment> viewAllAppointmentByDiagnosticCenter(int centerId) {
        return appointmentRepository.findAllAppointmentByDiagnosticCenter(centerId);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findAppointment(int appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public void approveAppointment(int appointmentId) {
    }
}
