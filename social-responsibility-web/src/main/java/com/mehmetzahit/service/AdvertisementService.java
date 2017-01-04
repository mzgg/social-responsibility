package com.mehmetzahit.service;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by GUNEY on 1.12.2016.
 */
@Path("/memberService")
public class AdvertisementService implements AdvertisementDAO {

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    @Override
    public void persistAdvertisement(Advertisement advertisement) {
        advertisementDAO.persistAdvertisement(advertisement);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("find/{memberId}")
    @Override
    public List<Advertisement> advertisements(@PathParam("memberId") long memberId) {
        return advertisementDAO.advertisements(memberId);
    }

    @Override
    public List<Advertisement> publishedAdvertisement(long memberId) {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchAdvertisement/{searchAdvertisement}")
    @Override
    public Advertisement advertisement(@PathParam("searchAdvertisement") long advertisementNumber) {
        return advertisementDAO.advertisement(advertisementNumber);
    }

    @Override
    public Advertisement findAdvertisementById(long advertisementId) {
        return null;
    }
}
