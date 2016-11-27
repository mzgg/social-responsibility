package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;
import java.util.Random;

/**
 * Created by GUNEY on 27.11.2016.
 */

@ManagedBean
@RequestScoped
public class AdvertisementBean {
    private Advertisement advertisement = new Advertisement();
    private FileUploadView fileUploadView=new FileUploadView();

    @Getter
    @Setter
    private long advertisementNumber;

    @Getter
    @Setter
    private int city; //binding with setProperty

    @Getter
    @Setter
    private int district; //binding with setProperty

    public AdvertisementBean() {
        Random random = new Random();
        advertisementNumber = 100000 + random.nextInt(899999);
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }
    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public FileUploadView getFileUploadView() {
        return fileUploadView;
    }
    public void setFileUploadView(FileUploadView fileUploadView) {
        this.fileUploadView = fileUploadView;
    }

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);

    public void persist() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int petKind = Integer.parseInt(params.get("petKind"));
        int petRace = Integer.parseInt(params.get("petRace"));
        int training = Integer.parseInt(params.get("training"));
        System.out.println(fileUploadView.getFileName()+"dosya adı");
        advertisement.setAdvertisementNumber(advertisementNumber);
        advertisement.setPetKind(petKind);
        advertisement.setPetRace(petRace);
        advertisement.setTrainig(training);

        advertisement.setCity(city);
        advertisement.setDistrict(district);
        advertisementDAO.persistAdvertisement(advertisement);
    }
}
