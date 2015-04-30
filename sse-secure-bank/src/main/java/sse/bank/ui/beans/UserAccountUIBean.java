/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.servlet.jsp.PageContext;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.PageNameContext;
import sse.bank.business.util.PageNameContext.PAGE_SWITCHES;
import sse.bank.db.access.bean.gen.AccountFacade;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.CheckinAccount;
import sse.bank.db.domain.Customer;
import sse.bank.db.domain.SavingsAccount;

/**
 *
 * @author Raghunath
 */
@Named(value = "userAccountUIBean")
@SessionScoped
public class UserAccountUIBean implements Serializable {

    
    protected Customer customer;

    @EJB
    UserAccountBusinessBean userAccountBusinessBean;

    @EJB
    AccountFacade accountFacade;
    
    @Inject
    PageNameContext pageNameContext;
   
    CheckinAccount checkinAccount;
    SavingsAccount savingsAccount;
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   public String getDateString(){
       return new SimpleDateFormat("MM/dd/YY hh:mm").format(new Date());
   }

    public String switchToTransferPage2() {
        System.out.println("Switch To Transfer Page");

        pageNameContext.setUSER_SWITCHED_PAGE(PAGE_SWITCHES.FundTransferPage);

        return null;
    }

   public float getAccountBalance(){
       Collection<Account> col=customer.getAccountCollection();
       float balance=0;
       for (Account col1 : col) {
           Account flushedAccount=accountFacade.find(col1.getAccountNumber());
           balance+=flushedAccount.getBalance();
       }
       return balance;
   }
   
   public String logout() {
        System.out.println("Logout Page");
        pageNameContext.setUSER_SWITCHED_PAGE(PageNameContext.PAGE_SWITCHES.LogoutPage);
        return "/templates/public/LaunchPage.xhtml?faces-redirect=true";
    }

    public void initWithCustomer(Customer customer) {
        setCustomer(customer);
        checkinAccount=userAccountBusinessBean.getCheckinAccount(customer);
        savingsAccount=userAccountBusinessBean.getSavingsAccount(customer);
        
    }

    public CheckinAccount getCheckinAccount() {
        return checkinAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public void setCheckinAccount(CheckinAccount checkinAccount) {
        this.checkinAccount = checkinAccount;
    }
    
    
    
   

}
