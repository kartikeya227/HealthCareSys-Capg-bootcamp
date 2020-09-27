package com.cg.bootcamp.healthcare.controller;

import com.cg.bootcamp.healthcare.exceptions.RecordNotFoundException;
import com.cg.bootcamp.healthcare.model.Appointment;
import com.cg.bootcamp.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * Http Method : GET
     * Returns a list of all the appointments across all the diagnostic centers.
     * If no appointment is made in either of the centers returns a empty list.
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Appointment> viewAllAppointment() {
        return appointmentService.viewAllAppointment();
    }

    /**
     *Http Method : GET
     * Returns a list of all the appointments made by a particular user.
     * If no appointment is made by the user returns a empty list.
     * Takes user Id as input through path variable
     */
    @GetMapping("/byuser/{id}")
    @PreAuthorize("hasRole('USER')")
    public List<Appointment> viewAllAppointmentByUser(@PathVariable("id") int userId) {
        return appointmentService.viewAllAppointmentByUser(userId);
    }

    /**
     *Http Method : GET
     * Returns a list of all the appointments made under a particular diagnostic center.
     * If no appointment is made under particular diagnostic center returns a empty list.
     * Takes user Id as input through path variable
     */
    @GetMapping("/bycenter/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Appointment> viewAllAppointmentByDiagnosticCenter(@PathVariable("id") int centerId) {
        return appointmentService.viewAllAppointmentByDiagnosticCenter(centerId);
    }

    /**
     *Http Method : GET
     * Returns a single appointment by searching appointments table with appointment id.
     * If no appointment is present with that appointment id then return a error msg..
     * Takes user Id as input through path variable.
     * success code FOUND.
     * Fail code NOT FOUND.
     */
    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('ADMIN')")
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
     * Http Method : POST
     * Adds a new appointment to the database.
     * Takes appointment object in HTTP request body.
     * success code CREATED.
     * Fail code NOT BAD_REQUEST.
     */
    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment) {
        try {
            appointmentService.addAppointment(appointment);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Http Method : DELETE
     * Deletes a appointment from the database.
     * Takes appointment id as a path variable.
     * First checks if a appointment is present in the database with the provided
     * appointment id or not, if present deletes the appointment, else fires NOT_FOUND status.
     * success code OK.
     * Fail code NOT NOT_FOUND.
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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
     * Http Method : PUT
     * Updates a appointment already present in the database.
     * Takes appointment id as a path variable.
     * Takes appointment to be updated as a JASON object in HTTP request body
     * First checks if a appointment is present in the database with the provided
     * appointment id or not, if present Updates it with the new appointment, else fires NOT_FOUND status.
     * success code OK.
     * Fail code NOT NOT_FOUND.
     */
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appointment, @PathVariable("id") int appointmentId) {
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
     * Http Method : PUT
     * Approves a appointment already present in the database.
     * Takes appointment id as a path variable.
     * First checks if a appointment is present in the database with the provided
     * appointment id or not, if present approves the appointment, else fires NOT_FOUND status.
     * success code OK.
     * Fail code NOT NOT_FOUND.
     */
    @PutMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Appointment> approveAppointment(@PathVariable("id") int appointmentId) {
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
