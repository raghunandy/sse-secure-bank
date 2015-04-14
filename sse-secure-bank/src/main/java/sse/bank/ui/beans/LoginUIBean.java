/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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

@RequestScoped
public class LoginUIBean {

    private String userId;
    private String password;

    @Inject
    private UserAccountUIBean userAccountUIBean;

    @EJB
    UserAccountBusinessBean userAccountBean;

    public String login() {
        System.out.println("Login");
        Customer customer = userAccountBean.validate(userId, password);
        if (customer != null) {
            userAccountUIBean.setCustomer(customer);
            userAccountUIBean.setUSER_SWITCHED_PAGE(UserAccountUIBean.PAGE_SWITCHES.AccountHomePage);
            return "AccountCommonPage";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wrong User Credentials", "Please check username or password");
        FacesContext.getCurrentInstance().addMessage(null, message);

        return null;
    }

    public String switchToTransferPage2() {
        System.out.println("Switch To Transfer Page");

        userAccountUIBean.setUSER_SWITCHED_PAGE(UserAccountUIBean.PAGE_SWITCHES.FundTransferPage);

        return "AccountCommonPage";
    }

    public String logout() {
        System.out.println("Switch To Transfer Page");

        userAccountUIBean.setUSER_SWITCHED_PAGE(UserAccountUIBean.PAGE_SWITCHES.LogoutPage);

        return "AccountCommonPage";
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
