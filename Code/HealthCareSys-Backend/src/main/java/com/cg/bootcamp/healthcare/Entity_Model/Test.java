package com.cg.bootcamp.healthcare.Entity_Model;

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
}
