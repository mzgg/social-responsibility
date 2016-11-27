package com.mehmetzahit.bean;

/**
 * Created by GUNEY on 24.11.2016.
 */

import com.mehmetzahit.model.PetKind;
import com.mehmetzahit.model.PetRace;
import com.mehmetzahit.persistence.dao.PetKindDAO;
import com.mehmetzahit.persistence.dao.PetRaceDOA;
import com.mehmetzahit.persistence.jpa.PetKindDAOImpl;
import com.mehmetzahit.persistence.jpa.PetRaceDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {


    private Map<String, Map<Integer,String>> data = new HashMap<String, Map<Integer,String>>();
    private String country;
    private String city;
    private Map<Integer,String> countries;
    private Map<Integer,String> cities;
    private String training;
    private boolean visibility;
    private boolean visibilityForTrainingBox;
    private boolean visibilityForButton;

    public boolean isVisibility() {
        return visibility;
    }

    public boolean isVisibilityForTrainingBox() {
        return visibilityForTrainingBox;
    }

    public boolean isVisibilityForButton() {
        return visibilityForButton;
    }

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    PetKindDAO petKindDAO = context.getBean(PetKindDAOImpl.class);
    PetRaceDOA petRaceDOA = context.getBean(PetRaceDAOImpl.class);

    @PostConstruct
    public void init() {
        countries = new HashMap<Integer,String>();


        for (PetKind petKindList : petKindDAO.petKindList()) {
            countries.put(petKindList.getKindId(),petKindList.getKindName());

            Map<Integer,String> map = new HashMap< Integer,String>();
            for (PetRace petRaceList : petRaceDOA.findRaceByKind(petKindList.getKindId())) {
                map.put(petRaceList.getRaceId(),petRaceList.getRaceName());
            }

            System.out.println("haritaa"+map);
            data.put(petKindList.getKindName(), map);

        }

        System.out.println(countries);
        System.out.println(data);
    }

    public Map<String, Map< Integer,String>> getData() {
        return data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        System.out.println(country);
        visibility = true;
        visibilityForTrainingBox = false;
        visibilityForButton = false;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        System.out.println(city);
        this.visibilityForTrainingBox = true;
        visibilityForButton = false;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
        System.out.println(training);
        this.visibilityForButton = true;

    }

    public Map< Integer,String> getCountries() {
        return countries;
    }

    public Map< Integer,String> getCities() {
        return cities;
    }

    public void onCountryChange() {
        if (country != null && !country.equals(""))
            cities = data.get(countries.get(Integer.parseInt(country)));
        else
            cities = new HashMap<Integer,String>();
    }


}