/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sse.bank.business.FundTransferBusinessBean;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.PageNameContext;
import sse.bank.db.ui.gen.util.JsfUtil;

/**
 *
 * @author Raghunath
 */
@ViewScoped
@Named(value = "fundTransferUIBean")
public class FundTransferUIBean implements Serializable {

    private String toAccount;

    private String destAccount;
    private float amount;
    @EJB
    FundTransferBusinessBean fundTransferBusinessBean;
    @Inject
    UserAccountUIBean userAccountUIBean;
    @EJB
    UserAccountBusinessBean userAccountBusinessBean;

    @Inject
    PageNameContext pageNameContext;

    private boolean transactionFinished;

    public void anotherTransaction() {
        clear();
    }

    public String cancel() {
       return  goToHome();
    }

    public String goToHome() {
        System.out.println("Switch To Home Page");
        pageNameContext.setUSER_SWITCHED_PAGE(PageNameContext.PAGE_SWITCHES.AccountHomePage);
        return null;
    }

    public void clear() {
        amount = 0;
        toAccount = null;
        transactionFinished = false;
    }

    public void submit() {

        try {
            transactionFinished = fundTransferBusinessBean.transferFund(
                    userAccountUIBean.getCheckinAccount().getAccount(),
                    amount,
                    toAccount);
            if (transactionFinished) {
                JsfUtil.addSuccessMessage("Transfer Success");
            }
        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Server Error: " + ex.getClass().getSimpleName());
            Logger.getLogger(FundTransferUIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(String destAccount) {
        this.destAccount = destAccount;
    }

    
    
    
    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isTransactionFinished() {
        return transactionFinished;
    }

    public void setTransactionFinished(boolean transactionFinished) {
        this.transactionFinished = transactionFinished;
    }

}
