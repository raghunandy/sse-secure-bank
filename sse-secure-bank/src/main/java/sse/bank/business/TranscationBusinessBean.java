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
    
    
    public void saveTransaction(String id,Account fromAccountNumber,Account toAccountNumber, float fund) {
        BankTransaction tran=new BankTransaction(TRANSACTION.FUND_TRANSFER.name());
        
        tran.setDate(new Date());
        tran.setTransactionType(id);
        transactionFacade.create(tran);
        
        TransferTransaction transferTransaction=new TransferTransaction();
        
        transferTransaction.setAmount(fund);
        transferTransaction.setToAccount(toAccountNumber);
        transferTransaction.setFromAccount(fromAccountNumber);
        transferTransaction.setBankTransaction(tran);
        transferTransaction.setTransactionId(id);
        transferTransactionFacade.create(transferTransaction);
    }
    
}
