package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Message;

import java.util.List;

/**
 * Created by GUNEY on 16.12.2016.
 */
public interface MessageDAO {
    void persistMessage(Message message);
    List<Message> messageList(long senderMemberId,long receiverMemberId,long advertisementId);
    List<Message> messageListBox(long memberId);

}
