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
import sse.bank.db.access.bean.gen.TransferTransactionFacade;
import sse.bank.db.domain.TransferTransaction;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.db.ui.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class TransferTransactionController {

    public TransferTransactionController() {
        pagingInfo = new PagingInfo();
        converter = new TransferTransactionConverter();
    }
    private TransferTransaction transferTransaction = null;
    private List<TransferTransaction> transferTransactionItems = null;
    private TransferTransactionFacade jpaController = null;
    private TransferTransactionConverter converter = null;
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

    public TransferTransactionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TransferTransactionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "transferTransactionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTransferTransactionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTransferTransactionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TransferTransaction getTransferTransaction() {
        if (transferTransaction == null) {
            transferTransaction = (TransferTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransferTransaction", converter, null);
        }
        if (transferTransaction == null) {
            transferTransaction = new TransferTransaction();
        }
        return transferTransaction;
    }

    public String listSetup() {
        reset(true);
        return "transferTransaction_list";
    }

    public String createSetup() {
        reset(false);
        transferTransaction = new TransferTransaction();
        return "transferTransaction_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(transferTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TransferTransaction was successfully created.");
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
        return scalarSetup("transferTransaction_detail");
    }

    public String editSetup() {
        return scalarSetup("transferTransaction_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        transferTransaction = (TransferTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransferTransaction", converter, null);
        if (transferTransaction == null) {
            String requestTransferTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentTransferTransaction");
            JsfUtil.addErrorMessage("The transferTransaction with id " + requestTransferTransactionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String transferTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, transferTransaction);
        String currentTransferTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentTransferTransaction");
        if (transferTransactionString == null || transferTransactionString.length() == 0 || !transferTransactionString.equals(currentTransferTransactionString)) {
            String outcome = editSetup();
            if ("transferTransaction_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit transferTransaction. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(transferTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TransferTransaction was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTransferTransaction");
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
                JsfUtil.addSuccessMessage("TransferTransaction was successfully deleted.");
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

    public List<TransferTransaction> getTransferTransactionItems() {
        if (transferTransactionItems == null) {
            getPagingInfo();
            transferTransactionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return transferTransactionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "transferTransaction_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "transferTransaction_list";
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
        transferTransaction = null;
        transferTransactionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TransferTransaction newTransferTransaction = new TransferTransaction();
        String newTransferTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTransferTransaction);
        String transferTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, transferTransaction);
        if (!newTransferTransactionString.equals(transferTransactionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
