package com.cg.bootcamp.healthcare.Entity_Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DiagnosticCenter")
public class DiagnosticCenter {

    @Id
    @SequenceGenerator(name = "DiagnosticCenter_SEQ",sequenceName = "dc_seq",
            initialValue = 10001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DiagnosticCenter_SEQ")
    @Column(name = "Center_ID", nullable = false)
    private String centerId;

    @NotNull()
    @Column(name = "Center_Name", nullable = false)
    private String centerName;

    @NotNull()
    @Column(name = "List_of_Tests", nullable = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Test_FK")
    @OrderColumn(name="Seq_FK")
    private List<Test> testList;

    @NotNull()
    @Column(name = "List_of_Appointments", nullable = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Appointment_FK")
    @OrderColumn(name="Seq_FK")
    private List<Test> appointmentList;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    public List<Test> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Test> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
