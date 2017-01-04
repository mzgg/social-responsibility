package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Column(name = "GENDER")
    private int gender;

    @Column(name = "TRAINING")
    private int trainig;

    @Column(name = "STATUS")
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PUBLISHING_DATE")
    private Date publishinDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "FK_PET_KIND_ID")
    private PetKind petKind;


    @OneToOne
    @JoinColumn(name = "FK_PET_RACE_ID")
    private PetRace petRace;

    @OneToOne
    @JoinColumn(name = "FK_CITY_ID")
    private City city;

    @OneToOne
    @JoinColumn(name = "FK_DISTRICT_ID")
    private District district;

    @ManyToOne
    @JoinColumn(name = "FK_MEMBER_ID")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertisement",fetch = FetchType.EAGER)
    private List<AdvertisementImage> advertisementImageList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "advertisement",fetch = FetchType.LAZY)
    private List<Message> messageList;


    public Advertisement() {
    }

    public Advertisement(long advertisementId) {
        this.advertisementId = advertisementId;
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

    public PetKind getPetKind() {
        return petKind;
    }

    public void setPetKind(PetKind petKind) {
        this.petKind = petKind;
    }

    public PetRace getPetRace() {
        return petRace;
    }

    public void setPetRace(PetRace petRace) {
        this.petRace = petRace;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<AdvertisementImage> getAdvertisementImageList() {
        return advertisementImageList;
    }

    public void setAdvertisementImageList(List<AdvertisementImage> advertisementImageList) {
        this.advertisementImageList = advertisementImageList;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "advertisementId=" + advertisementId +
                ", advertisementNumber=" + advertisementNumber +
                ", advertisementTopic='" + advertisementTopic + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", trainig=" + trainig +
                ", status=" + status +
                ", publishinDate=" + publishinDate +
                ", endDate=" + endDate +
                ", petKind=" + petKind +
                ", petRace=" + petRace +
                ", city=" + city +
                ", district=" + district +
                ", member=" + member +
                ", advertisementImageList=" + advertisementImageList +
                '}';
    }
}
