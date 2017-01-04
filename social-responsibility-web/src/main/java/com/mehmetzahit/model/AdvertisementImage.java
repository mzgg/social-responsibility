package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 28.11.2016.
 */
@Entity(name = "ADVERTISEMENT_IMAGE")
public class AdvertisementImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADVERTISEMENT_IMAGE_ID")
    private int advertisementImageId;

    @Column(name = "ADVERTISEMENT_IMAGE_NAME")
    private String advertisementImageName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ADVERTISEMENT_ID",referencedColumnName = "ADVERTISEMENT_ID")
    private Advertisement advertisement;

    public AdvertisementImage() {
    }

    public AdvertisementImage(String advertisementImageName) {
        this.advertisementImageName = advertisementImageName;
    }

    public AdvertisementImage(String advertisementImageName, long advertisementNumber) {
        this.advertisementImageName = advertisementImageName;
    }

    public int getAdvertisementImageId() {
        return advertisementImageId;
    }

    public void setAdvertisementImageId(int advertisementImageId) {
        this.advertisementImageId = advertisementImageId;
    }

    public String getAdvertisementImageName() {
        return advertisementImageName;
    }

    public void setAdvertisementImageName(String advertisementImageName) {
        this.advertisementImageName = advertisementImageName;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }


}
