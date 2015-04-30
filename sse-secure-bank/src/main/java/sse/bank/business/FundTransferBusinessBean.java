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
    
    @EJB
    AccountFacade accountFacade;
    @Resource
    private UserTransaction userTransaction;

    public void transferFund(Account fromAccount, float fund,
            String toAccountNumber) throws Exception {

        
        try {
            userTransaction.begin();
            Account toAccount=accountFacade.find(toAccountNumber);
            confirmAccountDetail(toAccount);
            confirmAccountDetail(fromAccount);
            withdrawAmount(fromAccount, fund);

            confirmAccountDetail(toAccount);
            depositAmount(toAccount, fund);

            userTransaction.commit();
        } catch (InvalidAccountException exception) {
            userTransaction.rollback();
        } catch (InsufficientFundException exception) {
            userTransaction.rollback();
        } catch (PaymentException exception) {
            userTransaction.rollback();
        }
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
