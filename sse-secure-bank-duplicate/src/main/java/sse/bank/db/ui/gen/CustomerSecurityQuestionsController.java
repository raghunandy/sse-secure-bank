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
import sse.bank.db.access.bean.gen.CustomerSecurityQuestionsFacade;
import sse.bank.db.domain.CustomerSecurityQuestions;
import sse.bank.db.ui.gen.util.JsfUtil;
import sse.bank.db.ui.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class CustomerSecurityQuestionsController {

    public CustomerSecurityQuestionsController() {
        pagingInfo = new PagingInfo();
        converter = new CustomerSecurityQuestionsConverter();
    }
    private CustomerSecurityQuestions customerSecurityQuestions = null;
    private List<CustomerSecurityQuestions> customerSecurityQuestionsItems = null;
    private CustomerSecurityQuestionsFacade jpaController = null;
    private CustomerSecurityQuestionsConverter converter = null;
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

    public CustomerSecurityQuestionsFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (CustomerSecurityQuestionsFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "customerSecurityQuestionsJpa");
        }
        return jpaController;
    }

    public SelectItem[] getCustomerSecurityQuestionsItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getCustomerSecurityQuestionsItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public CustomerSecurityQuestions getCustomerSecurityQuestions() {
        if (customerSecurityQuestions == null) {
            customerSecurityQuestions = (CustomerSecurityQuestions) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCustomerSecurityQuestions", converter, null);
        }
        if (customerSecurityQuestions == null) {
            customerSecurityQuestions = new CustomerSecurityQuestions();
        }
        return customerSecurityQuestions;
    }

    public String listSetup() {
        reset(true);
        return "customerSecurityQuestions_list";
    }

    public String createSetup() {
        reset(false);
        customerSecurityQuestions = new CustomerSecurityQuestions();
        return "customerSecurityQuestions_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(customerSecurityQuestions);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("CustomerSecurityQuestions was successfully created.");
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
        return scalarSetup("customerSecurityQuestions_detail");
    }

    public String editSetup() {
        return scalarSetup("customerSecurityQuestions_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        customerSecurityQuestions = (CustomerSecurityQuestions) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCustomerSecurityQuestions", converter, null);
        if (customerSecurityQuestions == null) {
            String requestCustomerSecurityQuestionsString = JsfUtil.getRequestParameter("jsfcrud.currentCustomerSecurityQuestions");
            JsfUtil.addErrorMessage("The customerSecurityQuestions with id " + requestCustomerSecurityQuestionsString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String customerSecurityQuestionsString = converter.getAsString(FacesContext.getCurrentInstance(), null, customerSecurityQuestions);
        String currentCustomerSecurityQuestionsString = JsfUtil.getRequestParameter("jsfcrud.currentCustomerSecurityQuestions");
        if (customerSecurityQuestionsString == null || customerSecurityQuestionsString.length() == 0 || !customerSecurityQuestionsString.equals(currentCustomerSecurityQuestionsString)) {
            String outcome = editSetup();
            if ("customerSecurityQuestions_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit customerSecurityQuestions. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(customerSecurityQuestions);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("CustomerSecurityQuestions was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCustomerSecurityQuestions");
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
                JsfUtil.addSuccessMessage("CustomerSecurityQuestions was successfully deleted.");
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

    public List<CustomerSecurityQuestions> getCustomerSecurityQuestionsItems() {
        if (customerSecurityQuestionsItems == null) {
            getPagingInfo();
            customerSecurityQuestionsItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return customerSecurityQuestionsItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "customerSecurityQuestions_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "customerSecurityQuestions_list";
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
        customerSecurityQuestions = null;
        customerSecurityQuestionsItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        CustomerSecurityQuestions newCustomerSecurityQuestions = new CustomerSecurityQuestions();
        String newCustomerSecurityQuestionsString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCustomerSecurityQuestions);
        String customerSecurityQuestionsString = converter.getAsString(FacesContext.getCurrentInstance(), null, customerSecurityQuestions);
        if (!newCustomerSecurityQuestionsString.equals(customerSecurityQuestionsString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
