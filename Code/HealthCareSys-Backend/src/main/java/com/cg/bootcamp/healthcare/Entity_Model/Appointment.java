package com.cg.bootcamp.healthcare.Entity_Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @SequenceGenerator(name = "Appointment_SEQ",sequenceName = "ap_seq",
            initialValue = 10001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Appointment_SEQ")
    @Column(name = "Appointment_ID", nullable = false)
    private String appointmentId;

    @NotNull()
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "User_FK")
    private User user;

    @NotNull()

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "DC_FK")
    private DiagnosticCenter diagnosticCenter;

    @NotNull()
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "TEST_FK_AP")
    private Test test;

    @NotNull()
    @Column(name = "Date", nullable = false)
    private java.sql.Timestamp dateTime;

    @NotNull()
    @Column(name = "User", nullable = false)
    private boolean approved;


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
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

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
