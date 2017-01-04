package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by GUNEY on 4.01.2017.
 */
@ManagedBean
@RequestScoped
public class MemberBean {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


    public void banMember(long memberId) {
        Member member = memberDAO.findUser(memberId);
        member.setEnabled(0);
        memberDAO.updateMember(member);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Üye banlandı.."));
    }

    public void aktiveMember(long memberId) {
        Member member = memberDAO.findUser(memberId);
        member.setEnabled(1);
        memberDAO.updateMember(member);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Üye Aktif Edildi.."));
    }

    public List<Member> members() {
        return memberDAO.select();
    }
}
