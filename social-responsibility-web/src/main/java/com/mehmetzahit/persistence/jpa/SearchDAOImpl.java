package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Search;
import com.mehmetzahit.persistence.dao.PetRaceDOA;
import com.mehmetzahit.persistence.dao.SearchDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 7.12.2016.
 */
@Repository
public class SearchDAOImpl implements SearchDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Advertisement> searchList(Search search) {
        String qry = "SELECT a FROM ADVERTISEMENT a WHERE a.status=1";

        if (search.getPetKind() != -1) qry += " and a.petKind.kindId=:petKind";
        if (search.getPetRace() != -1) qry += " and a.petRace.raceId=:petRace";
        if (search.getGender() != -1) qry += " and a.gender=:gender";
        if (search.getTraining() != -1) qry += " and a.trainig=:training";
        //age statement
        if (search.getCity() != -1) qry += " and a.city.cityId=:cityId";
        if (search.getDistrict() != -1) qry += " and a.district.districtId=:districtId";
        System.out.println(qry);

        Query query = entityManager.createQuery(qry);

        if (search.getPetKind() != -1) query.setParameter("petKind", search.getPetKind());
        if (search.getPetRace() != -1) query.setParameter("petRace", search.getPetRace());
        if (search.getGender() != -1) query.setParameter("gender", search.getGender());
        if (search.getTraining() != -1) query.setParameter("training", search.getTraining());
        //age statement
        if (search.getCity() != -1) query.setParameter("cityId", search.getCity());
        if (search.getCity() != -1) query.setParameter("districtId", search.getDistrict());


        List<Advertisement> searchtList = query.getResultList();
        return searchtList;
    }
}
