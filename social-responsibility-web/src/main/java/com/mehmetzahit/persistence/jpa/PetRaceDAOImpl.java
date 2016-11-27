package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.PetRace;
import com.mehmetzahit.persistence.dao.PetRaceDOA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 25.11.2016.
 */
@Repository
public class PetRaceDAOImpl implements PetRaceDOA {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<PetRace> petRaceList() {
        Query query = entityManager.createQuery("FROM PET_RACE");
        List<PetRace> petRaceList = query.getResultList();
        return petRaceList;
    }

    @Override
    @Transactional
    public List<PetRace>  findRaceByKind(int kindId) {
        Query query = entityManager.createQuery("FROM PET_RACE WHERE kindId=:kindId");
        query.setParameter("kindId",kindId);
        List<PetRace> petRaceList = query.getResultList();
        return petRaceList;
    }
}
