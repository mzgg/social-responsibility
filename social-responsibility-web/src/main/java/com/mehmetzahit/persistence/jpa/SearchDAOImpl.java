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
        Query query = entityManager.createQuery("FROM ADVERTISEMENT WHERE petKind.kindId=:petKind");
        query.setParameter("petKind", search.getPetKind());
       // query.setParameter("petRace", search.getPetRace());

        List<Advertisement> searchtList = query.getResultList();
        return searchtList;
    }
}
