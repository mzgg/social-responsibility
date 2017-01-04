package com.mehmetzahit.bean;

import com.mehmetzahit.model.*;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.dao.AdvertisementImageDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;
import com.mehmetzahit.persistence.jpa.AdvertisementImageDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by GUNEY on 27.11.2016.
 */

@ManagedBean
@SessionScoped
public class PublishAdvertisementBean {
    private Advertisement advertisement = new Advertisement();
    private List<String> advertisementImages = new ArrayList();

    private List<AdvertisementImage> advertisementImageList = new ArrayList<>();

    private AdvertisementImage image;

    @ManagedProperty("#{loginBean.userId}")
    @Getter
    @Setter
    private long userId;

    @Getter
    @Setter
    private long advertisementNumber;

    @Getter
    @Setter
    private int city; //binding with setProperty

    @Getter
    @Setter
    private int district; //binding with setProperty

    public PublishAdvertisementBean() {
        Random random = new Random();
        advertisementNumber = 100000 + random.nextInt(899999);
        System.out.println(advertisementNumber);
        advertisement.setAdvertisementImageList(new ArrayList<AdvertisementImage>());

    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);
    AdvertisementImageDAO advertisementImageDAO = context.getBean(AdvertisementImageDAOImpl.class);


    public void persist() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int petKind = Integer.parseInt(params.get("petKind"));
        int petRace = Integer.parseInt(params.get("petRace"));
        int training = Integer.parseInt(params.get("training"));

        advertisement.setAdvertisementNumber(advertisementNumber);
        advertisement.setPetKind(new PetKind(petKind)); //FK
        advertisement.setPetRace(new PetRace(petRace)); //FK
        advertisement.setTrainig(training);

        advertisement.setCity(new City(city)); //FK
        advertisement.setDistrict(new District(district));
        advertisement.setMember(new Member(userId)); //FK


        advertisementDAO.persistAdvertisement(advertisement);
        //  advertisementImageDAO.persistAdvertisementImage(advertisementImages);

        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("publishAdvertisementBean");
    }

    public void handleFileUpload(FileUploadEvent event) {
        String path = "C:\\Users\\GUNEY\\Desktop\\social-responsibility\\social-responsibility-web\\src\\main\\webapp\\resources\\upload";
//        String path = "C:\\Users\\GUNEY\\Desktop\\upload\\" + userId + "\\" + advertisementNumber;
//
//        File filem = new File(mainPath + userId);
//        if (!filem.exists()) filem.mkdir();
//
//        filem = new File(mainPath + userId + "\\" + advertisementNumber);
//        if (!filem.exists()) filem.mkdir();

        File uploadDirectory = new File(path);

        UploadedFile files = event.getFile();
        File file = new File(uploadDirectory, event.getFile().getFileName());

        try {
            storeInputStream(files.getInputstream(), file);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dosya yükleme başarılı"));

            String fileName = event.getFile().getFileName();
            image = new AdvertisementImage();
            image.setAdvertisement(advertisement);
            image.setAdvertisementImageName(fileName);
            advertisement.getAdvertisementImageList().add(image);

           // advertisementImageDAO.persistAdvertisementImage(image);
            //advertisementImages.add(fileName);
            // advertisementImageList.add(new AdvertisementImage(fileName));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dosya yükleme hatalı", e.getMessage()));

        }
    }


    private static void storeInputStream(InputStream in, File file) throws IOException {

        FileOutputStream out = new FileOutputStream(file);
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        while (true) {
            bytesRead = in.read(buffer);
            if (bytesRead > 0) {
                out.write(buffer, 0, bytesRead);

            } else {
                break;
            }
        }

        out.close();
        in.close();
    }
}
