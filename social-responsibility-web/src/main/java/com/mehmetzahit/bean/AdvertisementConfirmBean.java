package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementConfirmDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementConfirmDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by GUNEY on 3.01.2017.
 */
@ManagedBean
@RequestScoped
public class AdvertisementConfirmBean {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementConfirmDAO advertisementConfirmDAO = context.getBean(AdvertisementConfirmDAOImpl.class);

    public List<Advertisement> advertisements() {
        return advertisementConfirmDAO.advertisemenetList();
    }

    public void confirmAdvertisement(long advertisementId){
        advertisementConfirmDAO.confirmAdvertisement(advertisementId);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("İlan Yayınlandı.."));
    }

    public void revokeAdvertisement(long advertisementId){
        advertisementConfirmDAO.revokeAdvertisement(advertisementId);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("İlan Yayını Durduruldu.."));
    }
    public void removeAdvertisement(long advertisementId){
        advertisementConfirmDAO.removeAdvertisement(advertisementId);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("İlan Silindi.."));
    }
}

