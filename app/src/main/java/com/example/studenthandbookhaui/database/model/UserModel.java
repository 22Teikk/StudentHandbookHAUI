package com.example.studenthandbookhaui.database.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel extends BaseModel implements Serializable {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String studentCode;
    private String address;
    private String homeTown;
    private String avatar;
    private String religion;
    private String ethnicity;
    private String citizenId;

    public UserModel() {}

    public UserModel(String firstName, String lastName, String gender, Date dob, String studentCode, String address, String homeTown, String avatar, String religion, String ethnicity, String citizenId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.studentCode = studentCode;
        this.address = address;
        this.homeTown = homeTown;
        this.avatar = avatar;
        this.religion = religion;
        this.ethnicity = ethnicity;
        this.citizenId = citizenId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }
}
