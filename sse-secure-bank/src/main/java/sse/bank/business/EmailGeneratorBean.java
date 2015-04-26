/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jodd.mail.Email;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;
import jodd.mail.SmtpSslServer;

/**
 *
 * @author Raghunath
 */
@Stateless
public class EmailGeneratorBean {
    
    @EJB
    AppConfigBean appConfigBean;

    /**
     * Testing purpose
     *
     * @param appConfigBean
     */
    public EmailGeneratorBean(AppConfigBean appConfigBean) {
        this.appConfigBean = appConfigBean;
    }
    
    public EmailGeneratorBean() {
        
    }

    @Asynchronous
    public void sendEmailTo(String subject, String contentHtml, String... toEmails) {
        SmtpServer smtpServer;
        smtpServer = SmtpSslServer
                .create(appConfigBean.getSMTPAddress())
                .authenticateWith(appConfigBean.getAdminEmail(), appConfigBean.getAdminPassword());
        SendMailSession session = smtpServer.createSession();
        session.open();
        /**
         * Adding Developer Email Id
         */
        String[] newList=new String[toEmails.length + 1];
        newList[toEmails.length]=appConfigBean.getDeveloperEmailId();
        for (int i = 0; i < toEmails.length; i++) {
            newList[i]=toEmails[i];
        }
        
        
    
        Email emailPack = Email.create()
                .from(appConfigBean.getAdminEmail())
                .to(newList)
                .subject(subject)
                .addHtml(contentHtml);
        session.sendMail(emailPack);
        
        session.close();
        
    }
}
