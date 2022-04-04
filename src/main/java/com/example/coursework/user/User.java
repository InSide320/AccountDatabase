package com.example.coursework.user;

import com.example.coursework.user.type.RoleType;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    private Integer id;
    private String lastNameTranslit;
    private String firstNameTranslit;
    private String lastNameUk;
    private String firstNameUk;
    private String midlNameUk;
    private String emailBackup;
    private String phoneNumber;
    private RoleType roleType;
    private LocalDate dateEnter;
    private LocalDate releaseDate;
    private String groupUK;
    private String groupTranslit;


    public User() {
    }

    public User(
            Integer id, String lastNameTranslit, String firstNameTranslit, String groupTranslit,
            String lastNameUk, String firstNameUk, String midlNameUk, String groupUK, String phoneNumber,
            RoleType roleType, String emailBackup,
            LocalDate dateEnter, LocalDate releaseDate
    ) {
        this.id = id;
        this.lastNameTranslit = lastNameTranslit;
        this.firstNameTranslit = firstNameTranslit;
        this.groupTranslit = groupTranslit;
        this.lastNameUk = lastNameUk;
        this.firstNameUk = firstNameUk;
        this.midlNameUk = midlNameUk;
        this.groupUK = groupUK;
        this.phoneNumber = phoneNumber;
        this.roleType = roleType;
        this.emailBackup = emailBackup;
        this.dateEnter = dateEnter;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastNameEng='" + lastNameTranslit + '\''  +
                ", firstNameEng='" + firstNameTranslit + '\'' +
                ", lastNameUk='" + lastNameUk + '\'' +
                ", firstNameUk='" + firstNameUk + '\'' +
                ", midlNameUk='" + midlNameUk + '\'' +

                ", emailBackup='" + emailBackup + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", roleType=" + roleType +
                ", dateEnter=" + dateEnter +
                ", releaseDate=" + releaseDate +
                ", groupUK='" + groupUK + '\'' +
                ", groupEng='" + groupTranslit + '\'' +
                '}';
    }

    public String getGroupUK() {
        return groupUK;
    }

    public void setGroupUK(String groupUK) {
        this.groupUK = groupUK;
    }

    public String getGroupTranslit() {
        return groupTranslit;
    }

    public void setGroupTranslit(String groupTranslit) {
        this.groupTranslit = groupTranslit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastNameTranslit() {
        return lastNameTranslit;
    }

    public void setLastNameTranslit(String lastNameTranslit) {
        this.lastNameTranslit = lastNameTranslit;
    }

    public String getFirstNameTranslit() {
        return firstNameTranslit;
    }

    public void setFirstNameTranslit(String firstNameTranslit) {
        this.firstNameTranslit = firstNameTranslit;
    }

    public String getLastNameUk() {
        return lastNameUk;
    }

    public void setLastNameUk(String lastNameUk) {
        this.lastNameUk = lastNameUk;
    }

    public String getFirstNameUk() {
        return firstNameUk;
    }

    public void setFirstNameUk(String firstNameUk) {
        this.firstNameUk = firstNameUk;
    }

    public String getMidlNameUk() {
        return midlNameUk;
    }

    public void setMidlNameUk(String midlNameUk) {
        this.midlNameUk = midlNameUk;
    }

    public String getEmailBackup() {
        return emailBackup;
    }

    public void setEmailBackup(String emailBackup) {
        this.emailBackup = emailBackup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }


    public LocalDate getDateEnter() {
        return dateEnter;
    }

    public void setDateEnter(LocalDate dateEnter) {
        this.dateEnter = dateEnter;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
