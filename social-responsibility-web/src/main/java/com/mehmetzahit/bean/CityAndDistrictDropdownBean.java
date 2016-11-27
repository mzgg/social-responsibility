package com.mehmetzahit.bean;

import com.mehmetzahit.model.City;
import com.mehmetzahit.model.District;
import com.mehmetzahit.persistence.dao.CityDAO;
import com.mehmetzahit.persistence.dao.DistrictDAO;
import com.mehmetzahit.persistence.jpa.CityDAOImpl;
import com.mehmetzahit.persistence.jpa.DistrictDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GUNEY on 27.11.2016.
 */
@ManagedBean
@ViewScoped
public class CityAndDistrictDropdownBean {
    private Map<String, Map<Integer, String>> data = new HashMap<String, Map<Integer, String>>();
    private String city;
    private String district;
    private Map<Integer, String> cities;
    private Map<Integer, String> districts;

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    CityDAO cityDAO = context.getBean(CityDAOImpl.class);
    DistrictDAO districtDAO = context.getBean(DistrictDAOImpl.class);

    @PostConstruct
    public void init() {
        cities = new HashMap<Integer, String>();


        for (City city : cityDAO.cityList()) {
            cities.put(city.getCityId(), city.getCityName());
            Map<Integer, String> map = new HashMap<Integer, String>();

                for (District district : districtDAO.districtList(city.getCityId())) {

                    map.put(district.getDistrictId(), district.getDistrictName());
                }

                data.put(city.getCityName(), map);
        }

    }

    public void onCityChange() {
        if (city != null && !city.equals(""))
            districts = data.get(cities.get(Integer.parseInt(city)));
        else
            districts = new HashMap<Integer, String>();
    }


    public Map<String, Map<Integer, String>> getData() {
        return data;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Map<Integer, String> getCities() {
        return cities;
    }


    public Map<Integer, String> getDistricts() {
        return districts;
    }
}
