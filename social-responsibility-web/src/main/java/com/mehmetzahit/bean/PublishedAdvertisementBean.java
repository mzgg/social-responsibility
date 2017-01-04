package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by GUNEY on 29.11.2016.
 */
@ManagedBean
@RequestScoped
public class PublishedAdvertisementBean {

    @ManagedProperty("#{loginBean.userId}")
    @Getter
    @Setter
    private long memberId;

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);


    public List<Advertisement> advertisements() {
        List<Advertisement> advertisements = advertisementDAO.advertisements(memberId);
        return advertisements;
    }

    public List<Advertisement> publishedAdvertisement() {
        List<Advertisement> advertisements = advertisementDAO.publishedAdvertisement(memberId);
        return advertisements;
    }


}
