package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import java.io.Serializable;

/**
 * Created by GUNEY on 1.11.2016.
 */
@ManagedBean
@RequestScoped
public class MemberRegistrationBean implements Serializable {
    @Getter
    @Setter
    private Member member = new Member();

    @Getter
    @Setter
    private String confirmPassword;

    @Getter
    @Setter
    private boolean visibility = true;


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


    public void userRegistrationValidate() {
        Member user = memberDAO.findUser(member.getEmailAddress());
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println(member);
        if (!confirmPassword.equals(member.getPassword())) {
            context.addMessage(null, new FacesMessage("Şifreler Uyuşmuyor"));

        } else if (user == null) {
            member.setRole(1);
            member.setEnabled(1);
            memberDAO.insertMember(member);
            visibility = false;
        } else {
            context.addMessage(null, new FacesMessage("Bu E-Posta adresi kullanılmaktadır."));
        }

    }


}
