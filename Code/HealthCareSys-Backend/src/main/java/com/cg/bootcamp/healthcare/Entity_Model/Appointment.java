package com.cg.bootcamp.healthcare.Entity_Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

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

//    @NotNull()
//    @Column(name = "Date", nullable = false)
//    private java.sql.Timestamp dateTime;

    @NotNull()
    private boolean approved;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", user=" + user +
                ", diagnosticCenter=" + diagnosticCenter +
                ", test=" + test +
                ", approved=" + approved +
                '}';
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
