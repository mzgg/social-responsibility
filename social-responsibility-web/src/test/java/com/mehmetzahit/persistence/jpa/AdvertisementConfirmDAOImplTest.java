package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementConfirmDAO;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by GUNEY on 3.01.2017.
 */
public class AdvertisementConfirmDAOImplTest {


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementConfirmDAO advertisementConfirmDAO = context.getBean(AdvertisementConfirmDAOImpl.class);

    @Test
    public void advertisemenetList() throws Exception {
        List<Advertisement> advertisements = advertisementConfirmDAO.advertisemenetList();
        System.out.println(advertisements);
        Assert.assertNotNull(advertisements);
    }

    @Test
    public void confirmAdvertisement() throws Exception {
        advertisementConfirmDAO.confirmAdvertisement(3);

    }

    @Test
    public void revokeAdvertisement() throws Exception {
        advertisementConfirmDAO.revokeAdvertisement(3);
    }

    @Test
    public void removeAdvertisement() throws Exception {
        int count = advertisementConfirmDAO.advertisemenetList().size();
        advertisementConfirmDAO.removeAdvertisement(1);
        int count2 = advertisementConfirmDAO.advertisemenetList().size();
        Assert.assertNotEquals(count, count2);


    }

}