/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.jsf.gen;

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
import sse.bank.db.domain.SavingsAccount;
import sse.bank.jsf.gen.bean.SavingsAccountFacade;
import sse.bank.jsf.gen.util.JsfUtil;
import sse.bank.jsf.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class SavingsAccountController {

    public SavingsAccountController() {
        pagingInfo = new PagingInfo();
        converter = new SavingsAccountConverter();
    }
    private SavingsAccount savingsAccount = null;
    private List<SavingsAccount> savingsAccountItems = null;
    private SavingsAccountFacade jpaController = null;
    private SavingsAccountConverter converter = null;
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

    public SavingsAccountFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (SavingsAccountFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "savingsAccountJpa");
        }
        return jpaController;
    }

    public SelectItem[] getSavingsAccountItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getSavingsAccountItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public SavingsAccount getSavingsAccount() {
        if (savingsAccount == null) {
            savingsAccount = (SavingsAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentSavingsAccount", converter, null);
        }
        if (savingsAccount == null) {
            savingsAccount = new SavingsAccount();
        }
        return savingsAccount;
    }

    public String listSetup() {
        reset(true);
        return "savingsAccount_list";
    }

    public String createSetup() {
        reset(false);
        savingsAccount = new SavingsAccount();
        return "savingsAccount_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(savingsAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("SavingsAccount was successfully created.");
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
        return scalarSetup("savingsAccount_detail");
    }

    public String editSetup() {
        return scalarSetup("savingsAccount_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        savingsAccount = (SavingsAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentSavingsAccount", converter, null);
        if (savingsAccount == null) {
            String requestSavingsAccountString = JsfUtil.getRequestParameter("jsfcrud.currentSavingsAccount");
            JsfUtil.addErrorMessage("The savingsAccount with id " + requestSavingsAccountString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String savingsAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, savingsAccount);
        String currentSavingsAccountString = JsfUtil.getRequestParameter("jsfcrud.currentSavingsAccount");
        if (savingsAccountString == null || savingsAccountString.length() == 0 || !savingsAccountString.equals(currentSavingsAccountString)) {
            String outcome = editSetup();
            if ("savingsAccount_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit savingsAccount. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(savingsAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("SavingsAccount was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentSavingsAccount");
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
                JsfUtil.addSuccessMessage("SavingsAccount was successfully deleted.");
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

    public List<SavingsAccount> getSavingsAccountItems() {
        if (savingsAccountItems == null) {
            getPagingInfo();
            savingsAccountItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return savingsAccountItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "savingsAccount_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "savingsAccount_list";
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
        savingsAccount = null;
        savingsAccountItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        SavingsAccount newSavingsAccount = new SavingsAccount();
        String newSavingsAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, newSavingsAccount);
        String savingsAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, savingsAccount);
        if (!newSavingsAccountString.equals(savingsAccountString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
