/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.ui.gen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import sse.bank.db.access.bean.gen.TransactionLogFacade;
import sse.bank.db.domain.TransactionLog;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.db.ui.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class TransactionLogController {

    public TransactionLogController() {
        pagingInfo = new PagingInfo();
        converter = new TransactionLogConverter();
    }
    private TransactionLog transactionLog = null;
    private List<TransactionLog> transactionLogItems = null;
    private TransactionLogFacade jpaController = null;
    private TransactionLogConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "org.glassfish-samples_sse-secure-bank_war_4.0-SNAPSHOTPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public TransactionLogFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TransactionLogFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "transactionLogJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTransactionLogItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTransactionLogItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TransactionLog getTransactionLog() {
        if (transactionLog == null) {
            transactionLog = (TransactionLog) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransactionLog", converter, null);
        }
        if (transactionLog == null) {
            transactionLog = new TransactionLog();
        }
        return transactionLog;
    }

    public String listSetup() {
        reset(true);
        return "transactionLog_list";
    }

    public String createSetup() {
        reset(false);
        transactionLog = new TransactionLog();
        return "transactionLog_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(transactionLog);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TransactionLog was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("transactionLog_detail");
    }

    public String editSetup() {
        return scalarSetup("transactionLog_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        transactionLog = (TransactionLog) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransactionLog", converter, null);
        if (transactionLog == null) {
            String requestTransactionLogString = JsfUtil.getRequestParameter("jsfcrud.currentTransactionLog");
            JsfUtil.addErrorMessage("The transactionLog with id " + requestTransactionLogString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String transactionLogString = converter.getAsString(FacesContext.getCurrentInstance(), null, transactionLog);
        String currentTransactionLogString = JsfUtil.getRequestParameter("jsfcrud.currentTransactionLog");
        if (transactionLogString == null || transactionLogString.length() == 0 || !transactionLogString.equals(currentTransactionLogString)) {
            String outcome = editSetup();
            if ("transactionLog_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit transactionLog. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(transactionLog);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TransactionLog was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTransactionLog");
        String id = idAsString;
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TransactionLog was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<TransactionLog> getTransactionLogItems() {
        if (transactionLogItems == null) {
            getPagingInfo();
            transactionLogItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return transactionLogItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "transactionLog_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "transactionLog_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        transactionLog = null;
        transactionLogItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TransactionLog newTransactionLog = new TransactionLog();
        String newTransactionLogString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTransactionLog);
        String transactionLogString = converter.getAsString(FacesContext.getCurrentInstance(), null, transactionLog);
        if (!newTransactionLogString.equals(transactionLogString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
