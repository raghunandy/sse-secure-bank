/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sse.bank.business.util.FacesUtil;

/**
 *
 * @author Raghunath
 */
@Named(value = "passwordResetUIBean")
@SessionScoped

public class PasswordResetUIBean extends UserAccountUIBean {

    private Map<String, String> securityQuestionIdAndUserAnswer;
    private String email;

    public String switechToResetPassword() {

        System.out.println("Switch To ResetPasswordPage");
        setUSER_SWITCHED_PAGE(UserAccountUIBean.PAGE_SWITCHES.ResetPasswordPage);
        return "AccountCommonPage";
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

}
