/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import java.util.Date;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sse.bank.db.access.bean.gen.OneTimePasswordFacade;
import sse.bank.db.domain.Customer;
import sse.bank.db.domain.OneTimePassword;

/**
 *
 * @author Raghunath
 */
@Stateless
public class OTPGeneratorBean {
    
    @EJB
    EmailGeneratorBean emailGeneratorBean;
    @EJB 
    OneTimePasswordFacade oneTimePasswordFacade;
    @Asynchronous
    public void generateOTP(Customer customer){
        OneTimePassword otp=new OneTimePassword();
        otp.setCreationDate(new Date());
        otp.setCustomerId(customer);
        
        
        /**
         * Pending
         */
        
        oneTimePasswordFacade.create(otp);
        
    }
    
}
