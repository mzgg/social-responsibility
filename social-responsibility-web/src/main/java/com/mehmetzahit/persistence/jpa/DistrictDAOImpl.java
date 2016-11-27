package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.District;
import com.mehmetzahit.persistence.dao.DistrictDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GUNEY on 27.11.2016.
 */
@Repository
public class DistrictDAOImpl implements DistrictDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<District> districtList(int cityId) {
        Query query = entityManager.createQuery("FROM DISTRICT WHERE cityId=:cityId");
        query.setParameter("cityId", cityId);
        List<District> districtList = query.getResultList();
        return districtList;
    }
}
