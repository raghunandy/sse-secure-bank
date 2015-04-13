/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.Stateless;
import sse.bank.db.domain.Account;

/**
 *
 * @author Raghunath
 */
@Stateless
public class UserAccountBusinessBean {

    public Account validate(String userId, String password) {
        return new Account();
    }
    
}
