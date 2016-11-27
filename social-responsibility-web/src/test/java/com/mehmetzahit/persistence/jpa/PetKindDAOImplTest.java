package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.PetKind;
import com.mehmetzahit.persistence.dao.MemberDAO;
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
 * Created by GUNEY on 25.11.2016.
 */
public class PetKindDAOImplTest {

    ConfigurableApplicationContext context;
    PetKindDAO petKindDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        petKindDAO = context.getBean(PetKindDAOImpl.class);
    }

    @After
    public void shutDown() throws Exception {
        context.close();
    }

    @Test
    public void petKindList() throws Exception {
        List<PetKind> petKindList = petKindDAO.petKindList();

        Assert.assertNotNull(petKindList);
    }

}