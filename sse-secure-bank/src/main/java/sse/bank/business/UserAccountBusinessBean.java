/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sse.bank.db.access.bean.gen.AccountFacade;
import sse.bank.db.access.bean.gen.CustomerFacade;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Stateless
public class UserAccountBusinessBean {

    @PersistenceContext(unitName = "org.glassfish-samples_sse-secure-bank_war_4.0-SNAPSHOTPU")
    private EntityManager em;

    @EJB
    AccountFacade accountFacade;

    @EJB
    CustomerFacade customerFacade;

    public Customer validate(String userId, String password) {

        Customer cus = customerFacade.find(userId);
        if(cus!=null&&cus.getCustomerId().equals(userId)&&cus.getPassword().equals(password)){
            return cus;
        }
//          Dummy Code for Testing
        
        return null;
    }

}
