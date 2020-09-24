package com.cg.bootcamp.healthcare.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    Date appointmentDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "hh:mm")
    Date AppointmentTime;

    @NotNull()
    private boolean approved;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", user=" + user +
                ", diagnosticCenter=" + diagnosticCenter +
                ", test=" + test +
                ", appointmentDate=" + appointmentDate +
                ", AppointmentTime=" + AppointmentTime +
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        AppointmentTime = appointmentTime;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
