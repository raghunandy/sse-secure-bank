/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.Singleton;

/**
 *
 * @author Raghunath
 */
@Singleton
public class AppConfigBean {

    public String getAdminEmail() {
        return "sse.securebank";
    }
   
    public String getAdminPassword() {
        return "welcomewelcome";
    }

    public String getSMTPAddress() {
        return "smtp.gmail.com";
    }
    
}
