package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.District;
import com.mehmetzahit.persistence.dao.DistrictDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 27.11.2016.
 */
public class DistrictDAOImplTest {
    @Test
    public void districtList() throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DistrictDAO districtDAO = context.getBean(DistrictDAOImpl.class);

        List<District> districtList = districtDAO.districtList(1);

        System.out.println(districtList);
        Assert.assertNotNull(districtList);

        context.close();
    }

}