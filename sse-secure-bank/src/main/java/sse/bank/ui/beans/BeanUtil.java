/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Raghunath
 */
public class BeanUtil {
    
     public static String hashAndSetPassword(String plainPassword) throws Exception {
      
        String hashedPassword = DigestUtils.md5Hex(plainPassword);
        return hashedPassword;
    }
}
