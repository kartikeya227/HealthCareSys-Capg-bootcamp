package com.cg.bootcamp.healthcare.model;

import com.cg.bootcamp.healthcare.exceptions.InvalidAgeException;
import com.cg.bootcamp.healthcare.exceptions.InvalidContactException;
import com.cg.bootcamp.healthcare.exceptions.InvalidEmailException;
import com.cg.bootcamp.healthcare.exceptions.InvalidNameException;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id", nullable = false)
    private int userId;

    @NotNull()
    @Column(name = "User_Name", nullable = false, unique = true, updatable = false)
    private String username;

    @NotNull()
    @Column(name = "Name", nullable = false)
    private String fullName;

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
    @Column(name = "User_Age")
    private int userAge;

    @NotNull()
    @Column(name = "User_Gender")
    private String userGender;

    @NotNull()
    @Column(name = "EmailId", nullable = false)
    private String emailId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setContactNumber(String contactNumber) throws InvalidContactException {
        String regexName = "^[1-9][0-9]{9}$";
        if (!contactNumber.matches(regexName))
            throw new InvalidContactException("Invalid contact number entered.");
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

    public void setEmailId(String emailId) throws InvalidEmailException {

        String regexName = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        if (!emailId.matches(regexName))
            throw new InvalidEmailException("Invalid Email entered.");

        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidNameException {

        String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
        String patternName = "(" + regexName + "){2,3}";

        if (!fullName.matches(patternName))
            throw new InvalidNameException("Invalid user full name Format");

        this.fullName = fullName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) throws InvalidAgeException {
        if (userAge <= 0 || userAge > 100)
            throw new InvalidAgeException("Invalid age entered, age can only be between 1-100.");
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
