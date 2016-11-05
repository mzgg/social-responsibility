package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.dao.MemberDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import java.io.Serializable;
import java.util.List;

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
    private boolean visibility = true;


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


    public void save(Member member) {
        member.setRole(1);
        memberDAO.insertMember(member);
        visibility = false;
    }

    public List<Member> Select() {
        return memberDAO.select();
    }


    public Member findUser(String email, String password) {

        return memberDAO.findUser(email, password);

    }

}
