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
import sse.bank.db.domain.CheckinAccount;
import sse.bank.jsf.gen.bean.CheckinAccountFacade;
import sse.bank.jsf.gen.util.JsfUtil;
import sse.bank.jsf.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class CheckinAccountController1 {

    public CheckinAccountController1() {
        pagingInfo = new PagingInfo();
        converter = new CheckinAccountConverter();
    }
    private CheckinAccount checkinAccount = null;
    private List<CheckinAccount> checkinAccountItems = null;
    private CheckinAccountFacade jpaController = null;
    private CheckinAccountConverter converter = null;
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

    public CheckinAccountFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (CheckinAccountFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "checkinAccountJpa");
        }
        return jpaController;
    }

    public SelectItem[] getCheckinAccountItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getCheckinAccountItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public CheckinAccount getCheckinAccount() {
        if (checkinAccount == null) {
            checkinAccount = (CheckinAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCheckinAccount", converter, null);
        }
        if (checkinAccount == null) {
            checkinAccount = new CheckinAccount();
        }
        return checkinAccount;
    }

    public String listSetup() {
        reset(true);
        return "checkinAccount_list";
    }

    public String createSetup() {
        reset(false);
        checkinAccount = new CheckinAccount();
        return "checkinAccount_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(checkinAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("CheckinAccount was successfully created.");
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
        return scalarSetup("checkinAccount_detail");
    }

    public String editSetup() {
        return scalarSetup("checkinAccount_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        checkinAccount = (CheckinAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCheckinAccount", converter, null);
        if (checkinAccount == null) {
            String requestCheckinAccountString = JsfUtil.getRequestParameter("jsfcrud.currentCheckinAccount");
            JsfUtil.addErrorMessage("The checkinAccount with id " + requestCheckinAccountString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String checkinAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, checkinAccount);
        String currentCheckinAccountString = JsfUtil.getRequestParameter("jsfcrud.currentCheckinAccount");
        if (checkinAccountString == null || checkinAccountString.length() == 0 || !checkinAccountString.equals(currentCheckinAccountString)) {
            String outcome = editSetup();
            if ("checkinAccount_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit checkinAccount. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(checkinAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("CheckinAccount was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCheckinAccount");
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
                JsfUtil.addSuccessMessage("CheckinAccount was successfully deleted.");
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

    public List<CheckinAccount> getCheckinAccountItems() {
        if (checkinAccountItems == null) {
            getPagingInfo();
            checkinAccountItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return checkinAccountItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "checkinAccount_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "checkinAccount_list";
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
        checkinAccount = null;
        checkinAccountItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        CheckinAccount newCheckinAccount = new CheckinAccount();
        String newCheckinAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCheckinAccount);
        String checkinAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, checkinAccount);
        if (!newCheckinAccountString.equals(checkinAccountString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
