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
import sse.bank.db.access.bean.gen.BankTransactionFacade;
import sse.bank.db.domain.BankTransaction;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.db.ui.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class BankTransactionController {

    public BankTransactionController() {
        pagingInfo = new PagingInfo();
        converter = new BankTransactionConverter();
    }
    private BankTransaction bankTransaction = null;
    private List<BankTransaction> bankTransactionItems = null;
    private BankTransactionFacade jpaController = null;
    private BankTransactionConverter converter = null;
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

    public BankTransactionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (BankTransactionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "bankTransactionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getBankTransactionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getBankTransactionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public BankTransaction getBankTransaction() {
        if (bankTransaction == null) {
            bankTransaction = (BankTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentBankTransaction", converter, null);
        }
        if (bankTransaction == null) {
            bankTransaction = new BankTransaction();
        }
        return bankTransaction;
    }

    public String listSetup() {
        reset(true);
        return "bankTransaction_list";
    }

    public String createSetup() {
        reset(false);
        bankTransaction = new BankTransaction();
        return "bankTransaction_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(bankTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("BankTransaction was successfully created.");
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
        return scalarSetup("bankTransaction_detail");
    }

    public String editSetup() {
        return scalarSetup("bankTransaction_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        bankTransaction = (BankTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentBankTransaction", converter, null);
        if (bankTransaction == null) {
            String requestBankTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentBankTransaction");
            JsfUtil.addErrorMessage("The bankTransaction with id " + requestBankTransactionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String bankTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, bankTransaction);
        String currentBankTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentBankTransaction");
        if (bankTransactionString == null || bankTransactionString.length() == 0 || !bankTransactionString.equals(currentBankTransactionString)) {
            String outcome = editSetup();
            if ("bankTransaction_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit bankTransaction. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(bankTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("BankTransaction was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentBankTransaction");
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
                JsfUtil.addSuccessMessage("BankTransaction was successfully deleted.");
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

    public List<BankTransaction> getBankTransactionItems() {
        if (bankTransactionItems == null) {
            getPagingInfo();
            bankTransactionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return bankTransactionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "bankTransaction_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "bankTransaction_list";
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
        bankTransaction = null;
        bankTransactionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        BankTransaction newBankTransaction = new BankTransaction();
        String newBankTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newBankTransaction);
        String bankTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, bankTransaction);
        if (!newBankTransactionString.equals(bankTransactionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
