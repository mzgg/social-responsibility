package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Message;
import com.mehmetzahit.persistence.dao.MessageDAO;
import com.mehmetzahit.persistence.jpa.MessageDAOImpl;
import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by GUNEY on 16.12.2016.
 */
@ManagedBean
@ViewScoped
@Data
public class SendMessageBean {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MessageDAO messageDAO = context.getBean(MessageDAOImpl.class);

    private Message message = new Message();



    @PostConstruct
    public List<Message> messageList() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        long senderMemberId = Long.parseLong(params.get("sender"));
        long advertisementId = Long.parseLong(params.get("advertisement"));
        long receiverMemberId = Long.parseLong(params.get("receiver"));

        message.setReceiverMemberId(receiverMemberId);
        message.setAdvertisement(new Advertisement(advertisementId));
        message.setSenderMemberId(senderMemberId);
        List<Message> messages = messageDAO.messageList(senderMemberId,receiverMemberId,advertisementId);
        System.out.println(messages);

        return messages;
    }

}
