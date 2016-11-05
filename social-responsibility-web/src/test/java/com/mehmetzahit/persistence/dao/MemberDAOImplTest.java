package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Member;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GUNEY on 1.11.2016.
 */
public class MemberDAOImplTest {


    @Test
    public void testInsertMember() throws Exception {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");

        Member member = new Member();
        MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


        member.setMemberName("Mehmet Zahit");
        member.setMemberSurname("Güney");

    }

}