/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Named(value = "userAccountUIBean")
@SessionScoped
public class UserAccountUIBean implements Serializable {

    private Customer customer;

    
    
    private  PAGE_SWITCHES USER_SWITCHED_PAGE;
    
    public static enum PAGE_SWITCHES {
        AccountHomePage, FundTransferPage, AccountDetailsEditPage, LogoutPage;
    };

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PAGE_SWITCHES getUSER_SWITCHED_PAGE() {
        return USER_SWITCHED_PAGE;
    }

    public void setUSER_SWITCHED_PAGE(PAGE_SWITCHES USER_SWITCHED_PAGE) {
        this.USER_SWITCHED_PAGE = USER_SWITCHED_PAGE;
    }

    
   public String switchToTransferPage2() {
        System.out.println("Switch To Transfer Page");

        setUSER_SWITCHED_PAGE(UserAccountUIBean.PAGE_SWITCHES.FundTransferPage);

        return "AccountCommonPage";
    }

}
