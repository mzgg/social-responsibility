package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.AdvertisementImage;
import com.mehmetzahit.persistence.dao.AdvertisementImageDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by GUNEY on 28.11.2016.
 */
@Repository
public class AdvertisementImageDAOImpl implements AdvertisementImageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void persistAdvertisementImage(AdvertisementImage advertisementImage) {

//        for (int i = 0; i < advertisementImages.size(); i++) {
//            AdvertisementImage image = new AdvertisementImage();
//            image.setAdvertisementImageName((String) advertisementImages.get(i));
//            entityManager.persist(image);
//        }
        entityManager.persist(advertisementImage);

    }
}
