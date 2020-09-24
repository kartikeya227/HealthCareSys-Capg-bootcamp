package com.cg.bootcamp.healthcare.service;

import com.cg.bootcamp.healthcare.dao.AppointmentRepository;
import com.cg.bootcamp.healthcare.dao.DiagnosticCenterRepository;
import com.cg.bootcamp.healthcare.dao.TestRepository;
import com.cg.bootcamp.healthcare.dao.UserRepository;
import com.cg.bootcamp.healthcare.model.Appointment;
import com.cg.bootcamp.healthcare.model.DiagnosticCenter;
import com.cg.bootcamp.healthcare.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;


    @Test
    void addAppointment_correct() {
        Appointment appointment = new Appointment();
        appointment = appointmentRepository.findById(8).get();
        Appointment newAppointment = new Appointment();
        appointment.setAppointmentId(newAppointment.getAppointmentId());
        String test = appointmentService.addAppointment(appointment);
        Assertions.assertEquals("Appointment successfully created!",test);
    }
    @Test
    void addAppointment_wrong() {
        Appointment appointment = new Appointment();
        appointment = appointmentRepository.findById(7).get();
        Appointment newAppointment = new Appointment();
        appointment.setAppointmentId(newAppointment.getAppointmentId());
        String test = appointmentService.addAppointment(appointment);
        Assertions.assertEquals("Appointment successfully created!",test);
    }

    @Test
    void deleteAppointment() {
    }

    @Test
    void viewAllAppointment_correct() {
        List<Appointment> a1= appointmentRepository.findAll();
        List<Appointment> a2= appointmentService.viewAllAppointment();
        Assertions.assertEquals(a1,a2);
    }
    @Test
    void viewAllAppointment_wrong() {
        Assertions.assertEquals(appointmentRepository.findAllAppointmentByUser(1),appointmentService.viewAllAppointment());
    }

    @Test
    void viewAllAppointmentByUser() {

    }

    @Test
    void viewAllAppointmentByDiagnosticCenter() {
    }

    @Test
    void updateAppointment() {
    }

    @Test
    void findAppointment() {
    }

    @Test
    void approveAppointment() {
    }
}