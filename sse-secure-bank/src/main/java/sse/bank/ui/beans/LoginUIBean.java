/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sse.bank.business.UserAccountBusinessBean;

import sse.bank.business.util.PageNameContext;
import sse.bank.db.domain.Customer;
import sse.bank.db.ui.gen.util.JsfUtil;

/**
 *
 * @author Raghunath
 */
@Named(value = "loginUIBean")
@ViewScoped
public class LoginUIBean implements Serializable{

    private String userId="cust001";
    private String password="hello";

    
    @Inject
    private UserAccountUIBean userAccountUIBean;
    
    @Inject 
    PageNameContext pageNameContext;
    @EJB
    UserAccountBusinessBean userAccountBean;

    public String login() {
        System.out.println("Login");
        Customer customer = userAccountBean.validate(userId, password);
        if (customer != null) {
            userAccountUIBean.setCustomer(customer);
            
            pageNameContext.setUSER_SWITCHED_PAGE(PageNameContext.PAGE_SWITCHES.AccountHomePage);
           // return "hello?faces-redirect=true";
            return "/templates/banking/AccountCommonPage.xhtml?faces-redirect=true";
        }
        JsfUtil.addErrorMessage(  "Wrong User Credentials");
        
        return null;
    }
    
   
    
    

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccountUIBean getUserAccountUIBean() {
        return userAccountUIBean;
    }

    public void setUserAccountUIBean(UserAccountUIBean userAccountUIBean) {
        this.userAccountUIBean = userAccountUIBean;
    }

}
