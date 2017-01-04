package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 27.11.2016.
 */
@Entity(name = "DISTRICT")
public class District implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISTRICT_ID")
    private int districtId;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @Column(name = "CITY_ID")
    private int cityId;

    public District() {
    }

    public District(String districtName, int cityId) {

        this.districtName = districtName;
        this.cityId = cityId;
    }

    public District(int districtId) {
        this.districtId = districtId;
    }

    public int getDistrictId() {

        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
