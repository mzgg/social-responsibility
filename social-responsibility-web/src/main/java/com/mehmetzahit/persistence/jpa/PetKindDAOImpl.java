package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.PetKind;
import com.mehmetzahit.persistence.dao.PetKindDAO;
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
public class PetKindDAOImpl implements PetKindDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<PetKind> petKindList() {
        Query query = entityManager.createQuery("FROM PET_KIND");
        List<PetKind> petKindList = query.getResultList();
        return petKindList;
    }
}
