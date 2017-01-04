package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Advertisement;

import java.util.List;

/**
 * Created by GUNEY on 27.11.2016.
 */
public interface AdvertisementDAO {
    void persistAdvertisement(Advertisement advertisement);
    List<Advertisement> advertisements(long memberId);
    List<Advertisement> publishedAdvertisement(long memberId);
    Advertisement advertisement(long advertisementNumber);
    Advertisement findAdvertisementById(long advertisementId);
}
