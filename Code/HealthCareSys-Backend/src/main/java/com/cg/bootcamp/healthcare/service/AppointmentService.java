package com.cg.bootcamp.healthcare.service;

import com.cg.bootcamp.healthcare.dao.AppointmentDao;
import com.cg.bootcamp.healthcare.dao.AppointmentRepository;
import com.cg.bootcamp.healthcare.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements AppointmentDao {

    /**
     * Linking Appointment repository to use all the database quries
     */
    @Autowired
    AppointmentRepository appointmentRepository;

    /**
     * Adds a new Appointment to the database.
     * Takes Appointment object as a input.
     */
    @Override
    public String addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return "Appointment successfully created!";
    }

    /**
     * Adds a Deletes Appointment from the database.
     * Takes Appointment Id as a input.
     */
    @Override
    public void deleteAppointment(int appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    /**
     * Returns a list of all the appointments present accross all the centers.
     * If no appointment made till now return a empty list.
     */
    @Override
    public List<Appointment> viewAllAppointment() {
        return appointmentRepository.findAll();
    }

    /**
     * Returns a list of all the appointments made by a particular user.
     * If no appointment made by that user return a empty list.
     * Takes user Id as a input.
     */
    @Override
    public List<Appointment> viewAllAppointmentByUser(int userId) {
        return appointmentRepository.findAllAppointmentByUser(userId);
    }

    /**
     * Returns a list of all the appointments made under a particular diagnostic center.
     * If no appointment made under that center return a empty list.
     * Takes center Id as a input.
     */
    @Override
    public List<Appointment> viewAllAppointmentByDiagnosticCenter(int centerId) {
        return appointmentRepository.findAllAppointmentByDiagnosticCenter(centerId);
    }

    /**
     * Updates an already present appointment in the datbase.
     * Takes Appointment object as a input to be updated.
     */
    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    /**
     * Finds a particular appointment by searching appointment IDs.
     * return optional<Appointment> if no appointment present with that appointment id
     */
    @Override
    public Optional<Appointment> findAppointment(int appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    /**
     * Approves an already present appointment in the database.
     * Takes Appointment Id as a input.
     */
    @Override
    public void approveAppointment(int appointmentId) {
    }
}
