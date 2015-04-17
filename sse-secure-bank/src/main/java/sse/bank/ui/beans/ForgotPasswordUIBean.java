/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.FacesUtil;
import sse.bank.business.util.PageNameContext;
import sse.bank.business.util.PageNameContext.PAGE_SWITCHES;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Named(value = "forgotPasswordUIBean")
@SessionScoped
public class ForgotPasswordUIBean implements Serializable{
    
    private Map<String, String> securityQuestionIdAndUserAnswer;
    private String email;
    
     protected Customer customer;

    @EJB
    UserAccountBusinessBean userAccountBean;
    
    
    @Inject 
    PageNameContext pageNameContext;
    
    public String switechToResetPassword() {

        System.out.println("Switch To ForgotPasswordPage");
        pageNameContext.setUSER_SWITCHED_PAGE(PAGE_SWITCHES.ForgotPasswordPage);
        return "GeneralPublicCommonPage";
    }

    public String performResetPassword() {

        System.out.println("Perform Reset Password.. ");

        if (userAccountBean.validateSecurityQuesionts(customer, securityQuestionIdAndUserAnswer)) {
            userAccountBean.sendResetPassword(customer);

            FacesUtil.setUINotificationMessage(FacesMessage.SEVERITY_INFO,
                    "Password Sent ! Please check your Email");

        } else {
            FacesUtil.setUINotificationMessage(FacesMessage.SEVERITY_WARN,
                    "User Verification Failed !");

        }
        return "AccountCommonPage";
    }

    public Map<String, String> getSecurityQuestionIdAndUserAnswer() {
        return securityQuestionIdAndUserAnswer;
    }

    public void setSecurityQuestionIdAndUserAnswer(Map<String, String> securityQuestionIdAndUserAnswer) {
        this.securityQuestionIdAndUserAnswer = securityQuestionIdAndUserAnswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

   
   
    
}
