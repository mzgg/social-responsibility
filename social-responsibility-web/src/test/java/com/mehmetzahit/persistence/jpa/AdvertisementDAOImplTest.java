package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 27.11.2016.
 */
public class AdvertisementDAOImplTest {
    @Test
    public void persistAdvertisement() throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AdvertisementDAO advertisementDAO=context.getBean(AdvertisementDAOImpl.class);

    }

}