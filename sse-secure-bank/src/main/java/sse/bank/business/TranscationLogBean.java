/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import sse.bank.db.access.bean.gen.TransactionFacade;

/**
 *
 * @author Raghunath
 */
@Stateless
public class TranscationLogBean {

    
    @EJB
    TransactionFacade transactionFacade;
    
    public void logTransaction(String reason,String messge){
        
    }
}
