package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.City;
import com.mehmetzahit.persistence.dao.CityDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by GUNEY on 27.11.2016.
 */
public class CityDAOImplTest {
    ConfigurableApplicationContext context;
    CityDAO cityDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        cityDAO = context.getBean(CityDAOImpl.class);
    }

    @After
    public void shutDown() throws Exception {
        context.close();
    }

    @Test
    public void cityList() throws Exception {
        List<City> cityList = cityDAO.cityList();
        Assert.assertNotNull(cityList);
    }

}