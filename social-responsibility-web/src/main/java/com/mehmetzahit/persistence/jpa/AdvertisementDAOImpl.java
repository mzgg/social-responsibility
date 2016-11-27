package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by GUNEY on 27.11.2016.
 */
@Repository
public class AdvertisementDAOImpl implements AdvertisementDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void persistAdvertisement(Advertisement advertisement) {
        entityManager.persist(advertisement);
    }
}
