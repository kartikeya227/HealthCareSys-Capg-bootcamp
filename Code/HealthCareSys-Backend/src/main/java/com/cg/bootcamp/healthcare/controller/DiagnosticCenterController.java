package com.cg.bootcamp.healthcare.controller;


import com.cg.bootcamp.healthcare.exceptions.RecordNotFoundException;
import com.cg.bootcamp.healthcare.model.DiagnosticCenter;
import com.cg.bootcamp.healthcare.service.DiagnosticCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/center")
@CrossOrigin(value = "http://localhost:4200")
public class DiagnosticCenterController {

    @Autowired
    DiagnosticCenterService diagnosticCenterService;

    /**
     *
     */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/all")
    public List<DiagnosticCenter> viewAllDiagnosticCenter() {
        return diagnosticCenterService.viewAllDiagnosticCenter();
    }

    /**
     * Get Http Request
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/find/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<DiagnosticCenter> findDiagnosticCenter(@PathVariable("id") int centerId) {
        Optional<DiagnosticCenter> findById = diagnosticCenterService.findDiagnosticCenter(centerId);
        try {
            if (findById.isPresent()) {
                DiagnosticCenter diagnosticCenter = findById.get();
                return new ResponseEntity<DiagnosticCenter>(diagnosticCenter, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No record found with the provided " + centerId + "Diagnostic center code.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Post Http Request
     */
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@Valid @RequestBody DiagnosticCenter diagnosticCenter) {
        try {
            diagnosticCenterService.addDiagnosticCenter(diagnosticCenter);
            return new ResponseEntity<DiagnosticCenter>(diagnosticCenter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }
    }

    /**
     * Delete Http Request
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DiagnosticCenter> deleteDiagnosticCenter(@PathVariable("id") int centerId) {
        Optional<DiagnosticCenter> findById = diagnosticCenterService.findDiagnosticCenter(centerId);
        try {
            if (findById.isPresent()) {
                diagnosticCenterService.deleteDiagnosticCenter(centerId);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No Diagnostic Center with Center Id " + centerId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Put Http Request
     */
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DiagnosticCenter> updateDiagnosticCenter(@Valid @RequestBody DiagnosticCenter diagnosticCenter, @PathVariable("id") int centerId) {
        Optional<DiagnosticCenter> findById = diagnosticCenterService.findDiagnosticCenter(centerId);
        try {
            if (findById.isPresent()) {
                diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter);
                return new ResponseEntity<DiagnosticCenter>(diagnosticCenter, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No Diagnostic Center with Center Id " + centerId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
