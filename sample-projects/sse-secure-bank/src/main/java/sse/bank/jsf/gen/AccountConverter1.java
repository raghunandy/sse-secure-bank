/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.jsf.gen;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sse.bank.db.domain.Account;

/**
 *
 * @author Raghunath
 */
public class AccountConverter1 implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String id = string;
        AccountController1 controller = (AccountController1) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "account");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Account) {
            Account o = (Account) object;
            return o.getCustomerId() == null ? "" : o.getCustomerId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: sse.bank.db.domain.Account");
        }
    }
    
}
