package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    @Transactional
    public List<Advertisement> advertisements(long memberId) {
        Query query = entityManager.createQuery("SELECT a FROM ADVERTISEMENT a WHERE a.member.memberId=:memberId AND a.status=0");
        query.setParameter("memberId", memberId);
        List<Advertisement> advertisements = query.getResultList();
        return advertisements;
    }

    @Override
    @Transactional
    public List<Advertisement> publishedAdvertisement(long memberId) {
        Query query = entityManager.createQuery("SELECT a FROM ADVERTISEMENT a WHERE a.member.memberId=:memberId AND a.status=1");
        query.setParameter("memberId", memberId);
        List<Advertisement> advertisements = query.getResultList();
        return advertisements;
    }




    @Override
    @Transactional
    public Advertisement advertisement(long advertisementNumber) {
        Query query = entityManager.createQuery("FROM ADVERTISEMENT WHERE advertisementNumber=:advertisementNumber");
        query.setParameter("advertisementNumber", advertisementNumber);
        Advertisement singleResult = (Advertisement) query.getSingleResult();
        return singleResult;
    }



    @Override
    @Transactional
    public Advertisement findAdvertisementById(long advertisementId) {
        Advertisement advertisement = entityManager.find(Advertisement.class, advertisementId);
        return advertisement;
    }
}
