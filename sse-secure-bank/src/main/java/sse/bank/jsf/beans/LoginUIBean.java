/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.jsf.beans;

import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.SessionBeanUtil;

import sse.bank.db.domain.Account;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Named(value = "loginUIBean")
@ManagedBean
@RequestScoped
public class LoginUIBean {
    
     private String userId;
     private String password;
     
   
    @ManagedProperty(value="#{userAccountUIBean}")
    private UserAccountUIBean userAccountUIBean;

     
     @EJB
     UserAccountBusinessBean userAccountBean;
     
    public String login(){
        System.out.println("Login");
        Customer customer=userAccountBean.validate(userId,password);
        if(customer!=null){
            userAccountUIBean.setCustomer(customer);
            return "AccountHomePage";
        }
           return "Error";     
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
