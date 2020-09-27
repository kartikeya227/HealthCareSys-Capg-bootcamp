package com.cg.bootcamp.healthcare.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Appointment_ID", nullable = false)
    private int appointmentId;
    @NotNull()
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;
    @NotNull()
    @ManyToOne
    @JoinColumn(name = "Center_Id")
    private DiagnosticCenter diagnosticCenter;
    @NotNull()
    @ManyToOne
    @JoinColumn(name = "Test_ID")
    private Test test;
    @NotNull()
    private boolean approved;
    @NotNull
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) throws ParseException {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timestamp);
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DiagnosticCenter getDiagnosticCenter() {
        return diagnosticCenter;
    }

    public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
        this.diagnosticCenter = diagnosticCenter;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
