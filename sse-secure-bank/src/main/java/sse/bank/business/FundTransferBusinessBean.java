/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import sse.bank.db.domain.Account;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import sse.bank.db.access.bean.gen.AccountFacade;

/**
 *
 * @author Raghunath Tutorial:
 * http://www.tutorialspoint.com/ejb/ejb_transactions.htm
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class FundTransferBusinessBean {

    @EJB
    UserAccountBusinessBean userAccountBusinessBean;

    @PersistenceContext(unitName = "org.glassfish-samples_sse-secure-bank_war_4.0-SNAPSHOTPU")
    private EntityManager em;

    @EJB
    AccountFacade accountFacade;
    @Resource
    private UserTransaction userTransaction;

    public boolean transferFund(Account fromAccount, float fund,
            String toAccountNumber) throws Exception {

        boolean success = false;
        try {
            if(fromAccount.getAccountNumber().equals(toAccountNumber)){
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
