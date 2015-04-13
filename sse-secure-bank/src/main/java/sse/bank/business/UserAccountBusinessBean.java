/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import sse.bank.db.domain.Account;
import sse.bank.jsf.business.bean.gen.AccountFacade;
import sse.bank.jsf.business.bean.gen.CustomerFacade;

/**
 *
 * @author Raghunath
 */
@Stateless
public class UserAccountBusinessBean {

    
    @EJB
    AccountFacade accountFacade;
            
    @EJB
    CustomerFacade customerFacade;
    public Account validate(String userId, String password) {
        
        customerFacade.
        
        
    }
    
}
