package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by GUNEY on 27.11.2016.
 */
@Entity(name = "ADVERTISEMENT")
public class Advertisement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADVERTISEMENT_ID")
    private long advertisementId;

    @Column(name = "ADVERTISEMENT_NUMBER")
    private long advertisementNumber;

    @Column(name = "ADVERTISEMENT_TOPIC")
    private String advertisementTopic;

    @Column(name = "AGE")
    private int age;

    @Column(name = "PET_KIND")
    private int petKind;

    @Column(name = "PET_RACE")
    private int petRace;

    @Column(name = "GENDER")
    private int gender;

    @Column(name = "TRAINING")
    private int trainig;

    @Column(name = "CITY")
    private int city;

    @Column(name = "DISTRICT")
    private int district;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "PUBLISHING_DATE")
    private Date publishinDate;

    @Column(name = "END_DATE")
    private Date endDate;

    public Advertisement() {
    }

    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public long getAdvertisementNumber() {
        return advertisementNumber;
    }

    public void setAdvertisementNumber(long advertisementNumber) {
        this.advertisementNumber = advertisementNumber;
    }

    public String getAdvertisementTopic() {
        return advertisementTopic;
    }

    public void setAdvertisementTopic(String advertisementTopic) {
        this.advertisementTopic = advertisementTopic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPetKind() {
        return petKind;
    }

    public void setPetKind(int petKind) {
        this.petKind = petKind;
    }

    public int getPetRace() {
        return petRace;
    }

    public void setPetRace(int petRace) {
        this.petRace = petRace;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTrainig() {
        return trainig;
    }

    public void setTrainig(int trainig) {
        this.trainig = trainig;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPublishinDate() {
        return publishinDate;
    }

    public void setPublishinDate(Date publishinDate) {
        this.publishinDate = publishinDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "advertisementId=" + advertisementId +
                ", advertisementNumber=" + advertisementNumber +
                ", advertisementTopic='" + advertisementTopic + '\'' +
                ", age=" + age +
                ", petKind=" + petKind +
                ", petRace=" + petRace +
                ", gender=" + gender +
                ", trainig=" + trainig +
                ", city=" + city +
                ", district=" + district +
                ", status=" + status +
                ", publishinDate=" + publishinDate +
                ", endDate=" + endDate +
                '}';
    }
}
