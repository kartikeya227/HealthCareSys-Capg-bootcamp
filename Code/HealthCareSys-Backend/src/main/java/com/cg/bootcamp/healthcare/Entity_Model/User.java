package com.cg.bootcamp.healthcare.Entity_Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id", nullable = false)
    private int userId;

    @NotNull()
    @Pattern(regexp = "(^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$)")
    @Column(name = "User_Name", nullable = false)
    private String userName;

    /**
     *  It contains at least 8 characters and at most 20 characters.
     *     It contains at least one digit.
     *     It contains at least one upper case alphabet.
     *     It contains at least one lower case alphabet.
     *     It contains at least one special character which includes !@#$%&*()-+=^.
     *     It doesn’t contain any white space.
     */
    @NotNull()
    @Pattern(regexp="(^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$)", message = "error")
    @Column(name = "Password", nullable = false)
    private String password;

    @Pattern(regexp="(^$|[0-9]{10})")
    @NotNull()
    @Column(name = "Contact_number", nullable = false)
    private String contactNumber;


    @NotNull()
    @Column(name = "User_Role", nullable = false)
    private String userRole;

    @NotNull()
    @Email
    @Column(name = "EmailId", nullable = false)
    private String emailId;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", userRole='" + userRole + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

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
