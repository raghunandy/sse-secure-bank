/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.ui.gen;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sse.bank.db.domain.Transaction;

/**
 *
 * @author Raghunath
 */
public class TransactionConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String id = string;
        TransactionController controller = (TransactionController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "transaction");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Transaction) {
            Transaction o = (Transaction) object;
            return o.getTransactionId() == null ? "" : o.getTransactionId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: sse.bank.db.domain.Transaction");
        }
    }
    
}
