/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.business.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Raghunath
 */

public class FacesUtil {

    public static void setUINotificationMessage(FacesMessage.Severity severity, String message) {
        FacesMessage fm = new FacesMessage(severity,
                message, message);

        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
}
