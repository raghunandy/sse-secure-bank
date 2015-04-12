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
import sse.bank.db.domain.Customer;
import sse.bank.jsf.gen.bean.CustomerFacade;
import sse.bank.jsf.gen.util.JsfUtil;
import sse.bank.jsf.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class CustomerController {

    public CustomerController() {
        pagingInfo = new PagingInfo();
        converter = new CustomerConverter();
    }
    private Customer customer = null;
    private List<Customer> customerItems = null;
    private CustomerFacade jpaController = null;
    private CustomerConverter converter = null;
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

    public CustomerFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (CustomerFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "customerJpa");
        }
        return jpaController;
    }

    public SelectItem[] getCustomerItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getCustomerItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Customer getCustomer() {
        if (customer == null) {
            customer = (Customer) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCustomer", converter, null);
        }
        if (customer == null) {
            customer = new Customer();
        }
        return customer;
    }

    public String listSetup() {
        reset(true);
        return "customer_list";
    }

    public String createSetup() {
        reset(false);
        customer = new Customer();
        return "customer_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(customer);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Customer was successfully created.");
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
        return scalarSetup("customer_detail");
    }

    public String editSetup() {
        return scalarSetup("customer_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        customer = (Customer) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCustomer", converter, null);
        if (customer == null) {
            String requestCustomerString = JsfUtil.getRequestParameter("jsfcrud.currentCustomer");
            JsfUtil.addErrorMessage("The customer with id " + requestCustomerString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String customerString = converter.getAsString(FacesContext.getCurrentInstance(), null, customer);
        String currentCustomerString = JsfUtil.getRequestParameter("jsfcrud.currentCustomer");
        if (customerString == null || customerString.length() == 0 || !customerString.equals(currentCustomerString)) {
            String outcome = editSetup();
            if ("customer_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit customer. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(customer);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Customer was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCustomer");
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
                JsfUtil.addSuccessMessage("Customer was successfully deleted.");
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

    public List<Customer> getCustomerItems() {
        if (customerItems == null) {
            getPagingInfo();
            customerItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return customerItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "customer_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "customer_list";
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
        customer = null;
        customerItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Customer newCustomer = new Customer();
        String newCustomerString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCustomer);
        String customerString = converter.getAsString(FacesContext.getCurrentInstance(), null, customer);
        if (!newCustomerString.equals(customerString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
