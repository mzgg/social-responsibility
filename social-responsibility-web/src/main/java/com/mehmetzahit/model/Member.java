package com.mehmetzahit.model;

import javax.persistence.*;
import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * Created by GUNEY on 1.11.2016.
 */
@Entity(name = "MEMBER")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long memberId;

    @QueryParam("memberName")
    @Column(name = "MEMBER_NAME")
    private String memberName;

    @QueryParam("memberSurname")
    @Column(name = "MEMBER_SURNAME")
    private String memberSurname;

    @QueryParam("emailAddress")
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @QueryParam("phone")
    @Column(name = "PHONE")
    private String phone;

    @QueryParam("password")
    @Column(name = "PASSWORD")
    private String password;

    @QueryParam("enabled")
    @Column(name = "ENABLED")
    private int enabled;

    @QueryParam("ROLE")
    @Column(name = "ROLE")
    private int role;


    public Member() {
    }

    public Member(long memberId) {
        this.memberId = memberId;
    }

    public Member(String memberName, String memberSurname, String emailAddress, String phone, String password, int enabled, int role) {
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberSurname() {
        return memberSurname;
    }

    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberSurname='" + memberSurname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                '}';
    }
}
