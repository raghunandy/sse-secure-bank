/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

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
import sse.bank.db.domain.Customer;
import sse.bank.db.domain.CustomerSecurityQuestions;
import sse.bank.db.ui.gen.util.JsfUtil;

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
                    cus.getPassword().equals(hashAndSetPassword(password)))) {
                return cus;
            }
//          Dummy Code for Testing
        } catch (Exception ex) {
            Logger.getLogger(UserAccountBusinessBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String hashAndSetPassword(String plainPassword) throws Exception {
        if (plainPassword == null) {
            throw new Exception("Password not specified");
        }
        if (plainPassword.equals("")) {
            throw new Exception("Password blank");
        }
        String hashedPassword = DigestUtils.md5Hex(plainPassword);
        return hashedPassword;
    }

    public boolean validateSecurityQuesionts(CustomerSecurityQuestions securityQuestions,
            CustomerSecurityQuestions securityQuestionIdAndUserAnswer) {

        return true;
    }

    @Asynchronous
    public void sendResetPassword(Customer customer) {

        customer.setResetPasswordToken(System.nanoTime() + ""); //Randomnumber
        customerFacade.edit(customer);

        emailGeneratorBean.sendEmailTo(customer.getEmail(), "Reset Password",
                "Reset Password Link: <br/>"
                + customer.getResetPasswordToken());

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
    
}
