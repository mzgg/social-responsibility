package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.City;
import com.mehmetzahit.persistence.dao.CityDAO;
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
public class CityDAOImpl implements CityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<City> cityList() {
        Query query = entityManager.createQuery("FROM CITY");
        List<City> cityList = query.getResultList();
        return cityList;
    }
}
