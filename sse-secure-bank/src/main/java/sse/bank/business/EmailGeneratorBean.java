/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business;

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

    @Asynchronous
    public void sendEmailTo(String email, String subject, String contentHtml) {
        SmtpServer smtpServer;
        smtpServer = SmtpSslServer
                .create("smtp.gmail.com")
                .authenticateWith(appConfigBean.getAdminEmail(), appConfigBean.getAdminPassword());
        SendMailSession session = smtpServer.createSession();
        session.open();

        Email emailPack = Email.create()
                .from(appConfigBean.getAdminEmail())
                .to(email)
                .subject(subject)
                .addHtml(contentHtml);
        session.sendMail(emailPack);

        session.close();
    }
}
