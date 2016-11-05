package com.mehmetzahit.service;

import com.mehmetzahit.bean.MemberRegistrationBean;
import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */
@Path("/memberService")
public class WebServices implements MemberDAO {

    MemberRegistrationBean memberBean = new MemberRegistrationBean();


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public void insertMember(@BeanParam Member member) {
        memberBean.save(member);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find")
    public Member findUser(@QueryParam("email") String email, @QueryParam("password") String password) {

        return memberBean.findUser(email, password);
    }
    //http://localhost:8080/application/memberService/find?email=mzg&password=1


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/select")
    public List<Member> select() {
        return memberBean.Select();
    }


}
