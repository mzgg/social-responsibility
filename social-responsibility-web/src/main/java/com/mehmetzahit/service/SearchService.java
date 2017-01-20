package com.mehmetzahit.service;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Search;
import com.mehmetzahit.persistence.dao.SearchDAO;
import com.mehmetzahit.persistence.jpa.SearchDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by GUNEY on 15.12.2016.
 */


@Path(value = "/searchService")
public class SearchService implements SearchDAO  {

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    SearchDAO searchDAO = context.getBean(SearchDAOImpl.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search/")
    @Override
    public List<Advertisement> searchList(@BeanParam Search search) {
        return searchDAO.searchList(search);
    }

    @Override
    public List<Advertisement> searchList(String keyword) {
        return null;
    }
}
