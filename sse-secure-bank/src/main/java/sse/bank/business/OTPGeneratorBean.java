/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raghunath
 */
@Stateless
public class OTPGeneratorBean {
    
    @EJB
    EmailGeneratorBean emailGeneratorBean;
    @Asynchronous
    public void generateOTP(String email){
        
    }
    
}
