package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 27.11.2016.
 */
@Entity(name = "CITY")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private int CityId;

    @Column(name = "CITY_NAME")
    private String CityName;

    public City() {
    }

    public City(String cityName) {

        CityName = cityName;
    }

    public int getCityId() {

        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "CityId=" + CityId +
                ", CityName='" + CityName + '\'' +
                '}';
    }
}
