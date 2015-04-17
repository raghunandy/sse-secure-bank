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
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.PageNameContext;
import sse.bank.business.util.PageNameContext.PAGE_SWITCHES;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Named(value = "userAccountUIBean")
@SessionScoped
public class UserAccountUIBean implements Serializable {

    protected Customer customer;

    @EJB
    UserAccountBusinessBean userAccountBean;

    
    @Inject
    PageNameContext pageNameContext;
   

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   

    public String switchToTransferPage2() {
        System.out.println("Switch To Transfer Page");

        pageNameContext.setUSER_SWITCHED_PAGE(PAGE_SWITCHES.FundTransferPage);

        return "AccountCommonPage";
    }

   
    

}
