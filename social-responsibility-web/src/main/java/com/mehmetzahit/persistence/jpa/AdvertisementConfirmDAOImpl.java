package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementConfirmDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by GUNEY on 3.01.2017.
 */
@Repository
public class AdvertisementConfirmDAOImpl implements AdvertisementConfirmDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Advertisement> advertisemenetList() {
        Query query = entityManager.createQuery("SELECT a FROM ADVERTISEMENT a ORDER BY a.status ASC ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void confirmAdvertisement(long advertisementId) {
        Advertisement advertisement = entityManager.find(Advertisement.class, advertisementId);
        //Date endDate=new Date(new Date().getTime()+(20000*60*60*24));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);

        advertisement.setStatus(1);
        advertisement.setPublishinDate(new Date());
        advertisement.setEndDate(calendar.getTime());

        entityManager.merge(advertisement);
    }

    @Override
    @Transactional
    public void revokeAdvertisement(long advertisementId) {
        Advertisement advertisement = entityManager.find(Advertisement.class, advertisementId);

        advertisement.setStatus(3);
        advertisement.setEndDate(new Date());

        entityManager.merge(advertisement);

    }
    @Override
    @Transactional
    public void removeAdvertisement(long advertisementId) {
        Advertisement advertisement=entityManager.find(Advertisement.class,advertisementId);
        entityManager.remove(advertisement);

    }


}
