package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */
@Repository
public class MemberDAOImpl implements MemberDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertMember(Member member) {
        entityManager.persist(member);
    }

    @Override
    @Transactional
    public List<Member> select() {

        Query query = entityManager.createQuery("FROM MEMBER");
        List<Member> members = query.getResultList();

        return members;
    }

    @Override
    @Transactional
    public Member findUser(String email, String password) {
        Query query = entityManager.createQuery("SELECT M FROM MEMBER M WHERE M.emailAddress=:emailQuery  AND M.password=:passwordQuery", Member.class);

        query.setParameter("emailQuery", email);
        query.setParameter("passwordQuery", password);

        Member members = (Member) query.getSingleResult();
        return members;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
