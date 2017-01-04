package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.persistence.dao.AdvertisementImageDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;
import com.mehmetzahit.persistence.jpa.AdvertisementImageDAOImpl;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 28.11.2016.
 */
public class AdvertisementImageDAOImplTest {

    @Test
    public void persistAdvertisementImage() throws Exception {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdvertisementImageDAO advertisementImageDAO=context.getBean(AdvertisementImageDAOImpl.class);

        List images=new ArrayList();
        images.add("mzg");
        images.add("zahit");

       // advertisementImageDAO.persistAdvertisementImage((long) 53,images);


    }

}