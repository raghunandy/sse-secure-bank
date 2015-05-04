/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import sse.bank.db.access.bean.gen.BankTransactionFacade;

import sse.bank.db.access.bean.gen.TransferTransactionFacade;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.BankTransaction;

import sse.bank.db.domain.TransferTransaction;

/**
 *
 * @author Raghunath
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class TranscationBusinessBean {

    public static enum TRANSACTION{FUND_TRANSFER}
    
    @EJB
    BankTransactionFacade transactionFacade;

    @EJB
    TransferTransactionFacade transferTransactionFacade;
    
    
   
}
