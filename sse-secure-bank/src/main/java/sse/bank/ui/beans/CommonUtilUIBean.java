/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Raghunath
 */
@ApplicationScoped
@Named(value = "commonUtilUIBean")
public class CommonUtilUIBean {
    
     public String getDateString(){
       return new SimpleDateFormat("MM/dd/YY hh:mm").format(new Date());
   }

}
