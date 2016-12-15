package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Search;
import com.mehmetzahit.persistence.dao.SearchDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 9.12.2016.
 */
public class SearchDAOImplTest {

    @Test
    public void searchList() throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SearchDAO searchDAO = context.getBean(SearchDAOImpl.class);


        Search search = new Search();
        search.setPetKind(1);

        List<Advertisement> object = searchDAO.searchList(search);
        for(Advertisement advertisement:object){
            System.out.println(advertisement.getPetKind().getKindName());
        }
        Assert.assertNotNull(object);


    }

}