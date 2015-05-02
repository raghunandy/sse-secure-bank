/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business.util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Raghunath
 */
@Named(value = "pageNameContext")
@SessionScoped
public class PageNameContext implements Serializable {

    private PAGE_SWITCHES USER_SWITCHED_PAGE;

    public static enum PAGE_SWITCHES {

        AccountHomePage, FundTransferPage, AccountDetailsEditPage,
        LogoutPage, ForgotPasswordPage, LoginPage,EditProfile;
    };

    public PAGE_SWITCHES getUSER_SWITCHED_PAGE() {
        return USER_SWITCHED_PAGE;
    }

    public void setUSER_SWITCHED_PAGE(PAGE_SWITCHES USER_SWITCHED_PAGE) {
        this.USER_SWITCHED_PAGE = USER_SWITCHED_PAGE;
    }

    public String goToLoginPage() {

        setUSER_SWITCHED_PAGE(PAGE_SWITCHES.LoginPage);

        return "LaunchPage";
    }

}
