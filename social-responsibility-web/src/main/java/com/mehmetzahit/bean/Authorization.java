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
    @Getter
    private String email;
    public void setEmail(String email) {
        this.email = authentication.getName();
    }

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    public void login() {

        System.out.println("Login Metoduna Girildi");
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ServletException | IOException ex) {


        }
        /*finally {
            return null;
        }*/
        System.out.println("Login Metodundan Çıkıldı");
    }

    public void authorizedUserControl() {


        if (!authentication.getPrincipal().toString().equals("anonymousUser")) {

            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/advertisementStatus.xhtml?faces-redirect=true");

        }
    }
}
