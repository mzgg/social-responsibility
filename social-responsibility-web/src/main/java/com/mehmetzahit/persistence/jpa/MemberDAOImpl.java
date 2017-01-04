package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
        try {
            TypedQuery<Member> query = entityManager.createQuery("SELECT M FROM MEMBER M WHERE M.emailAddress=:emailQuery  AND M.password=:passwordQuery", Member.class);
            query.setParameter("emailQuery", email);
            query.setParameter("passwordQuery", password);

            return query.getSingleResult();

        } catch (Exception e) {
            return null;

        }

    }

    @Override
    @Transactional
    public Member findUser(String email) {
        try {
            TypedQuery<Member> query = entityManager.createQuery("SELECT M FROM MEMBER M WHERE M.emailAddress=:emailQuery", Member.class);
            query.setParameter("emailQuery", email);

            return query.getSingleResult();

        } catch (Exception e) {
            return null;

        }

    }

    @Override
    @Transactional
    public Member findUser(long userId) {
        Member member = entityManager.find(Member.class, userId);
        return member;
    }

    @Override
    @Transactional
    public void updateMember(Member member) {
        entityManager.merge(member);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
