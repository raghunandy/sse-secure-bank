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
import sse.bank.db.access.bean.gen.OneTimePasswordFacade;
import sse.bank.db.domain.OneTimePassword;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.db.ui.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class OneTimePasswordController {

    public OneTimePasswordController() {
        pagingInfo = new PagingInfo();
        converter = new OneTimePasswordConverter();
    }
    private OneTimePassword oneTimePassword = null;
    private List<OneTimePassword> oneTimePasswordItems = null;
    private OneTimePasswordFacade jpaController = null;
    private OneTimePasswordConverter converter = null;
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

    public OneTimePasswordFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (OneTimePasswordFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "oneTimePasswordJpa");
        }
        return jpaController;
    }

    public SelectItem[] getOneTimePasswordItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getOneTimePasswordItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public OneTimePassword getOneTimePassword() {
        if (oneTimePassword == null) {
            oneTimePassword = (OneTimePassword) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentOneTimePassword", converter, null);
        }
        if (oneTimePassword == null) {
            oneTimePassword = new OneTimePassword();
        }
        return oneTimePassword;
    }

    public String listSetup() {
        reset(true);
        return "oneTimePassword_list";
    }

    public String createSetup() {
        reset(false);
        oneTimePassword = new OneTimePassword();
        return "oneTimePassword_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(oneTimePassword);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("OneTimePassword was successfully created.");
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
        return scalarSetup("oneTimePassword_detail");
    }

    public String editSetup() {
        return scalarSetup("oneTimePassword_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        oneTimePassword = (OneTimePassword) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentOneTimePassword", converter, null);
        if (oneTimePassword == null) {
            String requestOneTimePasswordString = JsfUtil.getRequestParameter("jsfcrud.currentOneTimePassword");
            JsfUtil.addErrorMessage("The oneTimePassword with id " + requestOneTimePasswordString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String oneTimePasswordString = converter.getAsString(FacesContext.getCurrentInstance(), null, oneTimePassword);
        String currentOneTimePasswordString = JsfUtil.getRequestParameter("jsfcrud.currentOneTimePassword");
        if (oneTimePasswordString == null || oneTimePasswordString.length() == 0 || !oneTimePasswordString.equals(currentOneTimePasswordString)) {
            String outcome = editSetup();
            if ("oneTimePassword_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit oneTimePassword. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(oneTimePassword);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("OneTimePassword was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentOneTimePassword");
        Integer id = new Integer(idAsString);
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
                JsfUtil.addSuccessMessage("OneTimePassword was successfully deleted.");
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

    public List<OneTimePassword> getOneTimePasswordItems() {
        if (oneTimePasswordItems == null) {
            getPagingInfo();
            oneTimePasswordItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return oneTimePasswordItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "oneTimePassword_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "oneTimePassword_list";
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
        oneTimePassword = null;
        oneTimePasswordItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        OneTimePassword newOneTimePassword = new OneTimePassword();
        String newOneTimePasswordString = converter.getAsString(FacesContext.getCurrentInstance(), null, newOneTimePassword);
        String oneTimePasswordString = converter.getAsString(FacesContext.getCurrentInstance(), null, oneTimePassword);
        if (!newOneTimePasswordString.equals(oneTimePasswordString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
