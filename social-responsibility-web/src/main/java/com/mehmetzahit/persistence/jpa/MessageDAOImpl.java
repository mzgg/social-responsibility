package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Message;
import com.mehmetzahit.persistence.dao.MessageDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 16.12.2016.
 */
@Repository
public class MessageDAOImpl implements MessageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void persistMessage(Message message) {
        entityManager.persist(message);
    }


    @Override
    public List<Message> messageList(long senderMemberId, long receiverMemberId, long advertisementId) {
        Query query = entityManager.createQuery("SELECT m FROM MESSAGE m WHERE m.advertisement.advertisementId=:adsId " +
                "and ((m.senderMemberId=:senderId and m.receiverMemberId=:receiverId) or" +
                " (m.senderMemberId=:receiverId and m.receiverMemberId=:senderId)) order by m.messageSendTime asc ");


        query.setParameter("adsId", advertisementId);
        query.setParameter("senderId", senderMemberId);
        query.setParameter("receiverId", receiverMemberId);

        return query.getResultList();
    }

    @Override
    public List<Message> messageListBox(long memberId) {
        Query query = entityManager.createQuery("SELECT m FROM MESSAGE m WHERE m.senderMemberId=:memberId OR m.receiverMemberId=:memberId group by m.receiverMemberId,m.senderMemberId ORDER BY m.messageSendTime DESC");
        query.setParameter("memberId", memberId);
        return query.getResultList();
    }
}
