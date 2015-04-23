/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package see.bank.business.testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sse.bank.business.AppConfigBean;
import sse.bank.business.EmailGeneratorBean;

/**
 *
 * @author Raghunath
 */
public class MailSendingTesiting {
    

    public MailSendingTesiting() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void send() {
         AppConfigBean appConfigBean=new AppConfigBean();
         EmailGeneratorBean g=new EmailGeneratorBean(appConfigBean);
         
         g.sendEmailTo("visumagic@gmail.com", "Hello", "Content --- <br/> New Line ");
         
     }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
