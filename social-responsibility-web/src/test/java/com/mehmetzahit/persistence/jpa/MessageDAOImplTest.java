package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Message;
import com.mehmetzahit.persistence.dao.MessageDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 16.12.2016.
 */
public class MessageDAOImplTest {

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MessageDAO messageDAO = context.getBean(MessageDAOImpl.class);

    @Test
    public void messageList() throws Exception {
        Message message=new Message(1,1,3);
        List<Message> object = messageDAO.messageList(1,1,3);
        System.out.println(object);
        Assert.assertNotNull(object);
    }

    @Test
    public void messageListBox() throws Exception {
        List<Message> object = messageDAO.messageListBox(1);
        System.out.println(object);
        Assert.assertNotNull(object);
    }

}