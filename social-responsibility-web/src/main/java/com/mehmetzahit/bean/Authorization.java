package com.mehmetzahit.bean;


import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by GUNEY on 4.11.2016.
 */
@ManagedBean
@SessionScoped
public class Authorization implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void login() {

        System.out.println("Login Metoduna Girildi");

        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            setEmail(authentication.getName());
            System.out.println(authentication.getName()+" bak bakalım");

        } catch (ServletException | IOException ex) {


        }
        /*finally {
            return null;
        }*/
        System.out.println("Login Metodundan Çıkıldı");
    }

}
