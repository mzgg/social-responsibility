package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.PetRace;
import com.mehmetzahit.persistence.dao.PetKindDAO;
import com.mehmetzahit.persistence.dao.PetRaceDOA;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 25.11.2016.
 */
public class PetRaceDAOImplTest {


    ConfigurableApplicationContext context;
    PetRaceDOA petRaceDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        petRaceDAO = context.getBean(PetRaceDAOImpl.class);
    }

    @After
    public void shutDown() throws Exception {
        context.close();
    }

    @Test
    public void petRaceList() throws Exception {
        List<PetRace> petRaceList = petRaceDAO.petRaceList();
        Assert.assertNotNull(petRaceList);

    }

    @Test
    public void findRaceByKind() throws Exception {
        List<PetRace> petRaceList =petRaceDAO.findRaceByKind(1);
        Assert.assertNotNull(petRaceList);
    }

}