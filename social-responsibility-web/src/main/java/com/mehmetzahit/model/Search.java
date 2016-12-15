package com.mehmetzahit.model;

import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * Created by GUNEY on 7.12.2016.
 */
public class Search implements Serializable {

    @QueryParam("petKind")
    private int petKind;

    @QueryParam("petRace")
    private int petRace;

    @QueryParam("gender")
    private int gender;

    @QueryParam("training")
    private int training;

    @QueryParam("ageFirst")
    private int ageFirst;

    @QueryParam("ageLast")
    private int ageLast;

    @QueryParam("city")
    private int city;

    @QueryParam("district")
    private int district;

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

    public int getTraining() {
        return training;
    }

    public void setTraining(int training) {
        this.training = training;
    }

    public int getAgeFirst() {
        return ageFirst;
    }

    public void setAgeFirst(int ageFirst) {
        this.ageFirst = ageFirst;
    }

    public int getAgeLast() {
        return ageLast;
    }

    public void setAgeLast(int ageLast) {
        this.ageLast = ageLast;
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
}
