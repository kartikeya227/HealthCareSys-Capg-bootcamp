package com.cg.bootcamp.healthcare.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Test_Table")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Test_ID", nullable = false)
    private int testId;

    @NotNull()
    @Column(name = "Test_Name", nullable = false)
    private String testName;

    @NotNull()
    @Column(name = "Test_Doctor", nullable = false)
    private String testDoctor;

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", testDoctor='" + testDoctor + '\'' +
                '}';
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDoctor() {
        return testDoctor;
    }

    public void setTestDoctor(String testDoctor) {
        this.testDoctor = testDoctor;
    }
}
