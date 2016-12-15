package com.mehmetzahit.bean;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Search;
import com.mehmetzahit.persistence.dao.SearchDAO;
import com.mehmetzahit.persistence.jpa.SearchDAOImpl;
import lombok.Data;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by GUNEY on 6.12.2016.
 */
@ManagedBean
@RequestScoped
@Data
public class SearchFormBean {


    private Search search = new Search();

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    SearchDAO searchDAO = context.getBean(SearchDAOImpl.class);

    public List<Advertisement> searchList() {
        return searchDAO.searchList(search);
    }


    public void test() {
        System.out.println("1. " + search.getPetKind());
        System.out.println("2. " + search.getPetRace());
        System.out.println("3. " + search.getGender());
        System.out.println("4. " + search.getTraining());
        System.out.println("5. " + search.getAgeFirst());
        System.out.println("6. " + search.getAgeLast());
        System.out.println("7. " + search.getCity());
        System.out.println("8. " + search.getDistrict());
    }


    public static void main(String[] args) {

    }
}
