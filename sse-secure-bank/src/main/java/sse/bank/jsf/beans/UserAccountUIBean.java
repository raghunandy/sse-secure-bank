/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.jsf.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    
    /**
     * Creates a new instance of UserAccountUIBean
     */
    public UserAccountUIBean() {
    }

   

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
}
