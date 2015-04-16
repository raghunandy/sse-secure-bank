/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.ui.gen;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sse.bank.db.domain.TransactionLog;

/**
 *
 * @author Raghunath
 */
public class TransactionLogConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String id = string;
        TransactionLogController controller = (TransactionLogController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "transactionLog");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TransactionLog) {
            TransactionLog o = (TransactionLog) object;
            return o.getLogId() == null ? "" : o.getLogId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: sse.bank.db.domain.TransactionLog");
        }
    }
    
}
