/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.ui.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.servlet.jsp.PageContext;
import sse.bank.business.UserAccountBusinessBean;
import sse.bank.business.util.PageNameContext;
import sse.bank.business.util.PageNameContext.PAGE_SWITCHES;
import sse.bank.db.domain.Account;
import sse.bank.db.domain.Customer;

/**
 *
 * @author Raghunath
 */
@Named(value = "adminAccountUIBean")
@SessionScoped
public class AdminAccountUIBean implements Serializable {

    

    @EJB
    UserAccountBusinessBean userAccountBean;

    
    @Inject
    PageNameContext pageNameContext;
   

  
  
  
   
   public String logout() {
       return null;
    }
    

}
