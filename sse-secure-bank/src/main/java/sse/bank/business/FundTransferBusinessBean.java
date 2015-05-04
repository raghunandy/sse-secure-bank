/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import java.util.Date;
import sse.bank.db.domain.Account;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import sse.bank.business.TranscationBusinessBean.TRANSACTION;
import sse.bank.db.access.bean.gen.AccountFacade;
import sse.bank.db.domain.BankTransaction;
import sse.bank.db.domain.TransferTransaction;

/**
 *
 * @author Raghunath Tutorial:
 * http://www.tutorialspoint.com/ejb/ejb_transactions.htm
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class FundTransferBusinessBean  {

    @EJB
    UserAccountBusinessBean userAccountBusinessBean;

    @PersistenceContext(unitName = "org.glassfish-samples_sse-secure-bank_war_4.0-SNAPSHOTPU")
    private EntityManager em;

    @EJB
    AccountFacade accountFacade;
    @Resource
    private UserTransaction userTransaction;

    @EJB
    TranscationBusinessBean transcationBusinessBean;

    public boolean transferFund(Account fromAccount, float fund,
            String toAccountNumber) throws Exception {

        boolean success = false;
        try {
            if (fromAccount.getAccountNumber().equals(toAccountNumber)) {
                throw new InvalidAccountException();
            }
            Account toAccount = accountFacade.find(toAccountNumber);

            confirmAccountDetail(toAccount);

            confirmAccountDetail(fromAccount);
            try {
                userTransaction.begin();
                withdrawAmount(fromAccount, fund);

                depositAmount(toAccount, fund);
                em.merge(fromAccount);
                em.merge(toAccount);
                String transactionId = genTransactionId();
                saveTransaction(transactionId, fromAccount, toAccount, fund);
                userTransaction.commit();
                success = true;

            } catch (InsufficientFundException exception) {
                userTransaction.rollback();
                exception.printStackTrace();
                throw exception;
            } catch (PaymentException exception) {
                userTransaction.rollback();
                exception.printStackTrace();
                throw exception;
            }
        } catch (InvalidAccountException exception) {
            exception.printStackTrace();
            throw exception;

        }
        return success;
    }

    public void saveTransaction(String id, Account fromAccountNumber, Account toAccountNumber, float fund) {

        BankTransaction tran = new BankTransaction();
        tran.setTransactionType(TRANSACTION.FUND_TRANSFER.name());
        tran.setDate(new Date());
        tran.setBankTransactionId(id);
        tran.setAmount(fund);
        tran.setAccountNumber(fromAccountNumber);
        em.persist(tran);

        TransferTransaction transferTransaction = new TransferTransaction();

        
        transferTransaction.setToAccount(toAccountNumber);
        transferTransaction.setFromAccount(fromAccountNumber);
//        transferTransaction.setBankTransaction(tran);
        transferTransaction.setTransactionId(id);
        transferTransaction.setBankTransactionId(tran);
        em.persist(tran);
        

    }

    private void confirmAccountDetail(Account account)
            throws InvalidAccountException {
        if (account == null) {
            throw new InvalidAccountException();
        }
    }

    private void withdrawAmount(Account fromAccount, float fund) throws InsufficientFundException {
        if (fromAccount.getBalance() < fund) {
            throw new InsufficientFundException();
        }
        fromAccount.setBalance(fromAccount.getBalance() - fund);
    }

    private void depositAmount(Account toAccount, float fund) throws PaymentException {
        toAccount.setBalance(toAccount.getBalance() + fund);
    }

    private String genTransactionId() {
        return System.nanoTime() + "";
    }

    private static class PaymentException extends Exception {

        public PaymentException() {
        }
    }

    private static class InsufficientFundException extends Exception {

        public InsufficientFundException() {
        }
    }

    private static class InvalidAccountException extends Exception {

        public InvalidAccountException() {
        }
    }

}
