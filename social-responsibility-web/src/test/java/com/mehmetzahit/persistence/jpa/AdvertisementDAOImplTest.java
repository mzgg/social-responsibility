package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.AdvertisementImage;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.dao.PetKindDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 27.11.2016.
 */
public class AdvertisementDAOImplTest {



    ConfigurableApplicationContext context;
    AdvertisementDAO advertisementDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        advertisementDAO = context.getBean(AdvertisementDAOImpl.class);
    }

    @After
    public void shutDown() throws Exception {
        context.close();
    }

    @Test
    public void advertisements() throws Exception {
        List<Advertisement> advertisements = advertisementDAO.advertisements(1);
        Assert.assertNotNull(advertisements);
    }

    @Test
    public void advertisement() throws Exception {
        Advertisement advertisement = advertisementDAO.advertisement(444);
        Assert.assertNotNull(advertisement);
    }


    @Test
    public void findAdvertisementById() throws Exception {

        Advertisement advertisement=advertisementDAO.findAdvertisementById(3);
        System.out.println(advertisement);
        Assert.assertNotNull(advertisement);

    }


}