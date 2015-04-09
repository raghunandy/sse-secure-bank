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
import sse.bank.db.domain.Account;
import sse.bank.jsf.gen.bean.AccountFacade;
import sse.bank.jsf.gen.util.JsfUtil;
import sse.bank.jsf.gen.util.PagingInfo;

/**
 *
 * @author Raghunath
 */
public class AccountController1 {

    public AccountController1() {
        pagingInfo = new PagingInfo();
        converter = new AccountConverter();
    }
    private Account account = null;
    private List<Account> accountItems = null;
    private AccountFacade jpaController = null;
    private AccountConverter converter = null;
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

    public AccountFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (AccountFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "accountJpa");
        }
        return jpaController;
    }

    public SelectItem[] getAccountItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getAccountItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Account getAccount() {
        if (account == null) {
            account = (Account) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAccount", converter, null);
        }
        if (account == null) {
            account = new Account();
        }
        return account;
    }

    public String listSetup() {
        reset(true);
        return "account_list";
    }

    public String createSetup() {
        reset(false);
        account = new Account();
        return "account_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(account);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Account was successfully created.");
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
        return scalarSetup("account_detail");
    }

    public String editSetup() {
        return scalarSetup("account_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        account = (Account) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAccount", converter, null);
        if (account == null) {
            String requestAccountString = JsfUtil.getRequestParameter("jsfcrud.currentAccount");
            JsfUtil.addErrorMessage("The account with id " + requestAccountString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String accountString = converter.getAsString(FacesContext.getCurrentInstance(), null, account);
        String currentAccountString = JsfUtil.getRequestParameter("jsfcrud.currentAccount");
        if (accountString == null || accountString.length() == 0 || !accountString.equals(currentAccountString)) {
            String outcome = editSetup();
            if ("account_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit account. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(account);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Account was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentAccount");
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
                JsfUtil.addSuccessMessage("Account was successfully deleted.");
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

    public List<Account> getAccountItems() {
        if (accountItems == null) {
            getPagingInfo();
            accountItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return accountItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "account_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "account_list";
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
        account = null;
        accountItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Account newAccount = new Account();
        String newAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, newAccount);
        String accountString = converter.getAsString(FacesContext.getCurrentInstance(), null, account);
        if (!newAccountString.equals(accountString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
