/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sse.bank.business.UserAccountBusinessBean;

import sse.bank.business.util.PageNameContext;
import sse.bank.business.util.PageNameContext.PAGE_SWITCHES;
import sse.bank.db.domain.Customer;
import sse.bank.db.domain.CustomerSecurityQuestions;
import sse.bank.db.ui.gen.util.JsfUtil;

/**
 *
 * @author Raghunath
 */
@Named(value = "forgotPasswordUIBean")
@ViewScoped
public class ForgotPasswordUIBean implements Serializable {

    private CustomerSecurityQuestions securityQuestionsAndUserAnswer;
    private CustomerSecurityQuestions securityQuestions;

    private String custId;

    protected Customer customer;
    private FORGOT_PASSWORD_STAGES currentForgotPasswordStage;

    public static enum FORGOT_PASSWORD_STAGES {

        SEEK_CUSTOMER_ID, SEEK_ANSWERS, SUBMIT_MESSAGE
    };
    @EJB
    UserAccountBusinessBean userAccountBean;

    @Inject
    PageNameContext pageNameContext;

   

    public String switechToResetPassword() {

        System.out.println("Switch To ForgotPasswordPage");
        pageNameContext.setUSER_SWITCHED_PAGE(PAGE_SWITCHES.ForgotPasswordPage);
        setCurrentForgotPasswordStage(FORGOT_PASSWORD_STAGES.SEEK_CUSTOMER_ID);
        return "LunchPage";
    }

    public void initConversation() {
        System.out.println(" -- !");
    }


    public String submit(){
        if(currentForgotPasswordStage==FORGOT_PASSWORD_STAGES.SEEK_CUSTOMER_ID){
            return pullQuestions();
        }else if (currentForgotPasswordStage==FORGOT_PASSWORD_STAGES.SEEK_ANSWERS){
            return submitAnswers();
        }
        return null;
    }
    
    public String pullQuestions() {
       
        securityQuestionsAndUserAnswer=new CustomerSecurityQuestions();
        System.out.println("Switch To ForgotPasswordPage itself");
        securityQuestions=null;
        customer = userAccountBean.getCustomerByCustomerId(custId);
        if (customer == null) {

            JsfUtil.addSuccessMessage(
                    "No Customer Found with that Customenr Id");
        } else if (securityQuestions == null) {
            securityQuestions = customer.getCustomerSecurityQuestions();

            currentForgotPasswordStage = FORGOT_PASSWORD_STAGES.SEEK_ANSWERS;
        }
        return null;
    }

    public FORGOT_PASSWORD_STAGES getCurrentForgotPasswordStage() {
        return currentForgotPasswordStage;
    }

    public void setCurrentForgotPasswordStage(FORGOT_PASSWORD_STAGES currentForgotPasswordStage) {
        this.currentForgotPasswordStage = currentForgotPasswordStage;
    }

    public String submitAnswers() {

        if (userAccountBean.validateSecurityQuesionts(securityQuestions, securityQuestionsAndUserAnswer)) {

            JsfUtil.addSuccessMessage(
                    "Please check your email ... ");
            userAccountBean.sendResetPassword(customer);

        } else {

            JsfUtil.addErrorMessage(
                    "Wrong answers ... ");

        }
        currentForgotPasswordStage = FORGOT_PASSWORD_STAGES.SUBMIT_MESSAGE;

        return null;
    }

//    public String performResetPassword() {
//
//        System.out.println("Perform Reset Password.. ");
//
//        if (userAccountBean.validateSecurityQuesionts(customer, securityQuestionsAndUserAnswer)) {
//            userAccountBean.sendResetPassword(customer);
//
//            FacesUtil.setUINotificationMessage(FacesMessage.SEVERITY_INFO,
//                    "Password Sent ! Please check your Email");
//
//        } else {
//            FacesUtil.setUINotificationMessage(FacesMessage.SEVERITY_WARN,
//                    "User Verification Failed !");
//
//        }
//        return "AccountCommonPage";
//    }
    public CustomerSecurityQuestions getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(CustomerSecurityQuestions securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerSecurityQuestions getSecurityQuestionsAndUserAnswer() {
        return securityQuestionsAndUserAnswer;
    }

    public void setSecurityQuestionsAndUserAnswer(CustomerSecurityQuestions securityQuestionsAndUserAnswer) {
        this.securityQuestionsAndUserAnswer = securityQuestionsAndUserAnswer;
    }
    

}
