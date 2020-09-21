package com.cg.bootcamp.healthcare.Entity_Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_ID", nullable = false)
    private int userId;

    @NotNull()
    @Column(name = "User_Name", nullable = false)
    private String userName;

    @NotNull()
    @Column(name = "Password", nullable = false)
    private String password;

    @NotNull()
    @Column(name = "Contact_number", nullable = false)
    private String contactNumber;

    @NotNull()
    @Column(name = "User_Role", nullable = false)
    private String userRole;

    @NotNull()
    @Column(name = "EmailId", nullable = false)
    private String emailId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
