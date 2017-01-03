package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Member;
import com.mehmetzahit.model.Message;
import com.mehmetzahit.model.Search;
import com.mehmetzahit.persistence.dao.AdvertisementDAO;
import com.mehmetzahit.persistence.dao.MessageDAO;
import com.mehmetzahit.persistence.dao.SearchDAO;
import com.mehmetzahit.persistence.jpa.AdvertisementDAOImpl;
import com.mehmetzahit.persistence.jpa.MessageDAOImpl;
import com.mehmetzahit.persistence.jpa.SearchDAOImpl;
import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by GUNEY on 15.12.2016.
 */
@ManagedBean
@ViewScoped
@Data
public class MessagePageBean {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MessageDAO messageDAO = context.getBean(MessageDAOImpl.class);
    AdvertisementDAO advertisementDAO = context.getBean(AdvertisementDAOImpl.class);

    Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    long senderMemberId = Long.valueOf(params.get("senderMemberId"));
    long advertisementId = Long.valueOf(params.get("advertisementId"));
    long receiverMemberId = Long.valueOf(params.get("receiverMemberId"));

    private Advertisement advertisement=new Advertisement();
    private Message message = new Message(senderMemberId, receiverMemberId, advertisementId);

    public MessagePageBean() {
        System.out.println("cooooooooooooooooons" +advertisementId);
        advertisement = advertisementDAO.findAdvertisementById(advertisementId);
    }

    public String messagePage() {
        System.out.println("acabaaa" + message);
        System.out.println("ilan no :" + advertisementId);
        System.out.println("yanayi mi" + message.getSenderMemberId());


        System.out.println("bu gelmiyor galiab "+ message.getAdvertisement().getAdvertisementId());
        advertisement = advertisementDAO.findAdvertisementById(advertisementId);
        System.out.println("İLan NEsnesi :"+advertisement);
        return "/users/messages.xhtml";
    }

    public void sendMessage() {

        message.setMessageSendTime(new Date());
        System.out.println(message + "mesajlar");
        messageDAO.persistMessage(message);

        System.out.println("DB" +message);
        message = new Message(senderMemberId, receiverMemberId, advertisementId);
        System.out.println("yahu al mıyomu"+senderMemberId);
        System.out.println(message);
    }


    public List<Message> messageList() {
        //System.out.println("buralar değerleencek" +senderMemberId+"off"+advertisementId+"aha"+receiverMemberId);
        System.out.println("53acabaaa" + message);



        List<Message> messages = messageDAO.messageList(senderMemberId,receiverMemberId,advertisementId);
        System.out.println(messages);

        return messages;
    }


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
