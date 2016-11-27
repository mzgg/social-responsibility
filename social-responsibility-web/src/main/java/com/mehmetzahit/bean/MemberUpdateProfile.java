package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by GUNEY on 16.11.2016.
 */
@ManagedBean
@SessionScoped
public class MemberUpdateProfile implements Serializable {


    private Member member = new Member();

    @ManagedProperty("#{loginBean.userId}")
    private int userId;

    private boolean visibility;

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public String userProfile() {
        member = memberDAO.findUser(getUserId());
        System.out.println(member);
        return "/users/profile.xhtml?faces-redirect=true";
    }

    public void changeAktive() {
        setVisibility(true);
    }

    public void updateSave() {
        memberDAO.updateMember(member);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Bilgileriniz Başarıyla güncellendi"));
        setVisibility(false);
    }


}
