package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GUNEY on 1.11.2016.
 */
public class MemberDAOImplTest {

    ConfigurableApplicationContext context;
    MemberDAO memberDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        memberDAO = context.getBean(MemberDAOImpl.class);
    }

    @After
    public void shutDown() throws Exception {
        context.close();
    }

    @Test
    public void testUpdateMember() throws Exception {
        Member member = memberDAO.findUser(1);
        member.setPhone("0536");

        memberDAO.updateMember(member);
        Assert.assertNotNull(member);

    }

    @Test
    public void testFindUser1() throws Exception {
        Member member = memberDAO.findUser(1);
        Assert.assertNotNull(member);
    }


    @Test
    public void testFindUser() throws Exception {


        Member member = memberDAO.findUser("mzg", "1");
        Assert.assertNotNull(member);


    }


    @Test
    public void testInsertMember() throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Member member = new Member();
        MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


        member.setMemberName("Mehmet Zahit");
        member.setMemberSurname("Güney");

    }

}