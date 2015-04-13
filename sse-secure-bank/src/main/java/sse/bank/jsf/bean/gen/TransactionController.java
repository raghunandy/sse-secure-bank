/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.jsf.bean.gen;

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
import sse.bank.db.domain.Transaction;
import sse.bank.jsf.business.bean.gen.TransactionFacade;
import sse.bank.jsf.gen.util.JsfUtil;
import sse.bank.jsf.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class TransactionController {

    public TransactionController() {
        pagingInfo = new PagingInfo();
        converter = new TransactionConverter();
    }
    private Transaction transaction = null;
    private List<Transaction> transactionItems = null;
    private TransactionFacade jpaController = null;
    private TransactionConverter converter = null;
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

    public TransactionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TransactionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "transactionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTransactionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTransactionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Transaction getTransaction() {
        if (transaction == null) {
            transaction = (Transaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransaction", converter, null);
        }
        if (transaction == null) {
            transaction = new Transaction();
        }
        return transaction;
    }

    public String listSetup() {
        reset(true);
        return "transaction_list";
    }

    public String createSetup() {
        reset(false);
        transaction = new Transaction();
        return "transaction_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(transaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Transaction was successfully created.");
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
        return scalarSetup("transaction_detail");
    }

    public String editSetup() {
        return scalarSetup("transaction_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        transaction = (Transaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTransaction", converter, null);
        if (transaction == null) {
            String requestTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentTransaction");
            JsfUtil.addErrorMessage("The transaction with id " + requestTransactionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String transactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, transaction);
        String currentTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentTransaction");
        if (transactionString == null || transactionString.length() == 0 || !transactionString.equals(currentTransactionString)) {
            String outcome = editSetup();
            if ("transaction_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit transaction. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(transaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Transaction was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTransaction");
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
                JsfUtil.addSuccessMessage("Transaction was successfully deleted.");
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

    public List<Transaction> getTransactionItems() {
        if (transactionItems == null) {
            getPagingInfo();
            transactionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return transactionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "transaction_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "transaction_list";
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
        transaction = null;
        transactionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Transaction newTransaction = new Transaction();
        String newTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTransaction);
        String transactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, transaction);
        if (!newTransactionString.equals(transactionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
