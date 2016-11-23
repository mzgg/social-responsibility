package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Member;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */

public interface MemberDAO {
    void insertMember(Member member);

    List<Member> select();

    Member findUser(String email, String password);

    Member findUser(String email);

    Member findUser(int userId);

    void updateMember(Member member);

}
