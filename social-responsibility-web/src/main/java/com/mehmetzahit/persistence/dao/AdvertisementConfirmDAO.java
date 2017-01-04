package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Advertisement;

import java.util.List;

/**
 * Created by GUNEY on 3.01.2017.
 */
public interface AdvertisementConfirmDAO {
    List<Advertisement> advertisemenetList();
    void confirmAdvertisement(long advertisementId);
    void revokeAdvertisement(long advertisementId);
    void removeAdvertisement(long advertisementId);
}
