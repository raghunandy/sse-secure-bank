/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sse.bank.business.FundTransferBusinessBean;
import sse.bank.business.UserAccountBusinessBean;

/**
 *
 * @author Raghunath
 */

@ViewScoped
@Named(value = "fundTransferUIBean")
public class FundTransferUIBean {
    
    private String toAccount;
    
    private float amount;
    @EJB
    FundTransferBusinessBean fundTransferBusinessBean;
    @Inject
    UserAccountUIBean userAccountUIBean;
    @EJB
    UserAccountBusinessBean userAccountBusinessBean;
    private void anotherTransaction(){
        
    }
    private void cancle(){
        
    }
    private void submit(){
        
        
        try {
            fundTransferBusinessBean.transferFund(userAccountUIBean.getSavingsAccount().getAccount(),
                    amount,
                    toAccount);
        } catch (Exception ex) {
            Logger.getLogger(FundTransferUIBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
   
    
}
