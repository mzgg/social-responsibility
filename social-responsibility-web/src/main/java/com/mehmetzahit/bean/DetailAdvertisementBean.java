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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by GUNEY on 13.12.2016.
 */
@ManagedBean
@SessionScoped
public class DetailAdvertisementBean {

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    private Advertisement advertisement = new Advertisement();

    private long advertisementNumber = 0;

    @PostConstruct
    public void fill() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);

        String s = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("test");
        advertisementNumber = Long.valueOf(s);
        advertisement = advertisementDAO.advertisement(advertisementNumber);

        System.out.println(advertisement);

    }
}
