/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

/**
 *
 * @author Raghunath
 */

@ViewScoped
@Named(value = "accountEditUIBean")
public class AccountEditUIBean implements  Serializable{
    
    private String email;
    public void updateUserDetails(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
