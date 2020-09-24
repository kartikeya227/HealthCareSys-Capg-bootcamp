package com.cg.bootcamp.healthcare.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Diagnostic_Center")
public class DiagnosticCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Center_Id", nullable = false)
    private int centerId;

    @NotNull()
    @Column(name = "Center_Name", nullable = false)
    private String centerName;

    @NotNull()
    @Column(name = "Center_Address", nullable = false)
    private String centerAddrress;

    @NotNull()
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Test_C_ID")
    @OrderColumn(name = "Test_FK")
    private List<Test> testList;

    @Override
    public String toString() {
        return "DiagnosticCenter{" +
                "centerId=" + centerId +
                ", centerName='" + centerName + '\'' +
                ", centerAddrress='" + centerAddrress + '\'' +
                ", testList=" + testList +
                '}';
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAddrress() {
        return centerAddrress;
    }

    public void setCenterAddrress(String centerAddrress) {
        this.centerAddrress = centerAddrress;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
}
