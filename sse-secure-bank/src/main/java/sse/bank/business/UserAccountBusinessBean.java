/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import org.apache.commons.codec.digest.DigestUtils;
import sse.bank.db.access.bean.gen.AccountFacade;
import sse.bank.db.access.bean.gen.CustomerFacade;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.BankTransaction;
import sse.bank.db.domain.CheckinAccount;
import sse.bank.db.domain.Customer;
import sse.bank.db.domain.CustomerSecurityQuestions;
import sse.bank.db.domain.SavingsAccount;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.ui.beans.BeanUtil;

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

    @EJB
    EmailGeneratorBean emailGeneratorBean;

    @EJB
    AppConfigBean appConfigBean;

    
    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public Customer validate(String userId, String password) {

        Customer cus = customerFacade.find(userId);
        try {
            if (cus != null && (cus.getCustomerId().equals(userId)
                    && //<=== Change to &&
                    cus.getPassword().equals(BeanUtil.hashAndSetPassword(password)))) {
                return cus;
            }
//          Dummy Code for Testing
        } catch (Exception ex) {
            Logger.getLogger(UserAccountBusinessBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean validateSecurityQuesionts(CustomerSecurityQuestions securityQuestions,
            CustomerSecurityQuestions securityQuestionIdAndUserAnswer) {

        return true;
    }

    @Asynchronous
    public void sendResetPassword(Customer customer) {

        customer.setResetPasswordToken(System.nanoTime() + ""); //Randomnumber
        customerFacade.edit(customer);

        emailGeneratorBean.sendEmailTo("Reset Password",
                "Hello " + customer.getCustomerName() + "<br/>"
                + "Reset Password Link: <br/>"
                + genResetLink(customer.getResetPasswordToken()), customer.getEmail());

    }

    private String genResetLink(String key) {
        return appConfigBean.getAppBaseUrl()
                + "/faces/templates/public/ResetPasswordPage.xhtml?resetKey=" + key;
    }

    public void sendEmail(Customer customer, String text) {

    }

    public Customer getCustomerByCustomerId(String custId) {
        Query q = em.createNamedQuery("Customer.findByCustomerId");
        q.setParameter("customerId", custId);
        Customer c = null;
        try {
            c = (Customer) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }

    public void lockUserAccount(Customer cust) {
        cust.setAccountLocked(true);

        customerFacade.edit(cust);
    }

    public void unlockUserAccount(Customer cust) {
        cust.setAccountLocked(false);

        customerFacade.edit(cust);

    }

    public Customer findUserByResetPasswordKey(String resetKey) {

        Query d = em.createNamedQuery("Customer.findByResetPasswordToken");
        d.setParameter("resetPasswordToken", resetKey);
        try {
            Customer c = (Customer) d.getSingleResult();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public void setUserPassword(String newPassword, String resetKey) throws Exception {
        Customer cust = findUserByResetPasswordKey(resetKey);
        cust.setPassword(BeanUtil.hashAndSetPassword(newPassword));
        cust.setResetPasswordToken(null);
        customerFacade.edit(cust);

    }

    public CheckinAccount getCheckinAccount(Customer customer) {
        Collection<Account> accList = customer.getAccountCollection();
        for (Account a : accList) {
           if(a.getCheckinAccount()!=null){
               return a.getCheckinAccount();
           }
        }
        return null;
    }

    public SavingsAccount getSavingsAccount(Customer customer) {

        Collection<Account> accList = customer.getAccountCollection();
        for (Account a : accList) {
           if(a.getSavingsAccount()!=null){
               return a.getSavingsAccount();
           }
        }
        return null;

    }

    public List<BankTransaction> getTransactionsList(Account account) {
   
        Query q=em.createQuery("SELECT b FROM BankTransaction b WHERE b.accountNumber = :accountNumber order by b.date desc");
        q.setParameter("accountNumber", account);
        List<BankTransaction> list=q.getResultList();
        
        return list;
    }
    


}
