package com.mehmetzahit.bean;

import com.mehmetzahit.model.Message;
import com.mehmetzahit.persistence.dao.MessageDAO;
import com.mehmetzahit.persistence.jpa.MessageDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by GUNEY on 1.01.2017.
 */
@ManagedBean
@RequestScoped
public class MessageListBoxBean {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MessageDAO messageDAO = context.getBean(MessageDAOImpl.class);

    @ManagedProperty("#{loginBean.userId}")
    @Getter
    @Setter
    private long memberId;


    public List<Message> messageBoxList() {
        System.out.println(memberId);
        List<Message> x = messageDAO.messageListBox(memberId);
        System.out.println(x);
        return messageDAO.messageListBox(memberId);
    }
}
