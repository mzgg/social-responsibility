package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by GUNEY on 15.11.2016.
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class MemberLoginBean implements Serializable {

    private long userId;

    private String userName;
    private String password;
    private String email;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);

    public void userValidate() {
        Member user = memberDAO.findUser(getUserName(), getPassword());
        this.userId = user.getMemberId();
        System.out.println(this.userId);
        if (user == null) {
            System.out.println("hata");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("kullanıcıadı veye Şifre Hatalı"));


        }


        else {
            Authorization authorization = new Authorization();
            authorization.login();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            setEmail(authentication.getName());

        }
    }
}
