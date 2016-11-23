package com.mehmetzahit.service;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.dao.MemberDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */
@Path("/memberService")
public class MemberServices implements MemberDAO {

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public void insertMember(@BeanParam Member member) {
        memberDAO.insertMember(member);
    }
    //http://localhost:8080/application/memberService/save?memberName=zahit&emailAddress=deneme&password=123


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find")
    public Member findUser(@QueryParam("email") String email, @QueryParam("password") String password) {
        return memberDAO.findUser(email, password);
    }
    //http://localhost:8080/application/memberService/find?email=mzg&password=1

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find2")
    public Member findUser(@QueryParam("email") String email) {
        return memberDAO.findUser(email);
    }

    @Override
    public Member findUser(int userId) {
        return null;
    }

    @Override
    public void updateMember(Member member) {

    }
    //http://localhost:8080/application/memberService/find?email=mzg


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/select")
    public List<Member> select() {
        return memberDAO.select();
    }
    //http://localhost:8080/application/memberService/select
}
