/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sse.bank.business.UserAccountBusinessBean;

import sse.bank.business.util.PageNameContext;
import sse.bank.db.ui.gen.util.JsfUtil;

/**
 *
 * @author Raghunath
 */
@Named(value = "resetPasswordUIBean")
@ViewScoped
public class ResetPasswordUIBean implements Serializable {

    @EJB
    UserAccountBusinessBean userAccountBean;

    @Inject
    PageNameContext pageNameContext;

    private String newPassword;
    private String retypeNewPassword;
    @ManagedProperty(value = "#{param.resetKey}")
    private String resetKey;

    private boolean resetSuccess;

    public String submit() {

        System.out.println("Switch To ResetPasswordUIBean");
        if (!(newPassword != null && newPassword.equals(retypeNewPassword))) {
            JsfUtil.addErrorMessage("Miss mattch !");
            return null;
        }

        try {
            userAccountBean.setUserPassword(newPassword, resetKey);
        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Server Error !");
            Logger.getLogger(ResetPasswordUIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        resetSuccess = true;

        return "LunchPage";
    }

    public boolean isResetSuccess() {
        return resetSuccess;
    }

    public void setResetSuccess(boolean resetSuccess) {
        this.resetSuccess = resetSuccess;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRetypeNewPassword() {
        return retypeNewPassword;
    }

    public void setRetypeNewPassword(String retypeNewPassword) {
        this.retypeNewPassword = retypeNewPassword;
    }

   

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

}
