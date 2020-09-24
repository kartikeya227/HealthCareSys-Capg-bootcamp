package com.cg.bootcamp.healthcare.controller;

import com.cg.bootcamp.healthcare.model.Appointment;
import com.cg.bootcamp.healthcare.exceptions.RecordNotFoundException;
import com.cg.bootcamp.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(value = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    /**
     *
     */
    @GetMapping("/all")
    public List<Appointment> viewAllAppointment() {
        return appointmentService.viewAllAppointment();
    }

    /**
     *
     */
    @GetMapping("/byuser/{id}")
    public List<Appointment> viewAllAppointmentByUser(@PathVariable("id") int userId) {
        return appointmentService.viewAllAppointmentByUser(userId);
    }

    /**
     *
     */
    @GetMapping("/bycenter/{id}")
    public List<Appointment> viewAllAppointmentByDiagnosticCenter(@PathVariable("id") int centerId) {
        return appointmentService.viewAllAppointmentByDiagnosticCenter(centerId);
    }

    /**
     * Get Http Request
     */
    @GetMapping("/find/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Appointment> findAppointment(@PathVariable("id") int appointmentId) {
        Optional<Appointment> findById = appointmentService.findAppointment(appointmentId);
        try {
            if (findById.isPresent()) {
                Appointment appointment = findById.get();
                return new ResponseEntity<Appointment>(appointment, HttpStatus.FOUND);
            } else {
                throw new RecordNotFoundException("No appointment  with appointment Id " + appointmentId + " Appointment code.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Post Http Request
     */
    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment) {
        try {
            appointmentService.addAppointment(appointment);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }
    }

    /**
     * Delete Http Request
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") int appointmentId) {
        Optional<Appointment> findById = appointmentService.findAppointment(appointmentId);
        try {
            if (findById.isPresent()) {
                appointmentService.deleteAppointment(appointmentId);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No appointment  with apointment Id " + appointmentId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Put Http Request
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateDiagnosticCenter(@Valid @RequestBody Appointment appointment, @PathVariable("id") int appointmentId) {
        Optional<Appointment> findById = appointmentService.findAppointment(appointmentId);
        try {
            if (findById.isPresent()) {
                appointmentService.updateAppointment(appointment);
                return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No appointment  with apointment Id " + appointmentId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Put Http Request
     */
    @PutMapping("/approve/{id}")
    public ResponseEntity<Appointment> updateDiagnosticCenter(@PathVariable("id") int appointmentId) {
        Optional<Appointment> findById = appointmentService.findAppointment(appointmentId);
        try {
            if (findById.isPresent()) {
                Appointment appointment = findById.get();
                appointment.setApproved(true);
                appointmentService.updateAppointment(appointment);
                return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No appointment  with apointment Id " + appointmentId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
