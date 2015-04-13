<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New Account</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Account</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{account.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="AccountNumber:"/>
                    <h:inputText id="accountNumber" value="#{account.account.accountNumber}" title="AccountNumber" required="true" requiredMessage="The accountNumber field is required." />
                    <h:outputText value="Balance:"/>
                    <h:inputText id="balance" value="#{account.account.balance}" title="Balance" />
                    <h:outputText value="CheckinAccount:"/>
                    <h:selectOneMenu id="checkinAccount" value="#{account.account.checkinAccount}" title="CheckinAccount" >
                        <f:selectItems value="#{checkinAccount.checkinAccountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="TransferTransactionCollection:"/>
                    <h:selectManyListbox id="transferTransactionCollection" value="#{account.account.jsfcrud_transform[jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.arrayToList].transferTransactionCollection}" title="TransferTransactionCollection" size="6" converter="#{transferTransaction.converter}" >
                        <f:selectItems value="#{transferTransaction.transferTransactionItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="TransferTransactionCollection1:"/>
                    <h:selectManyListbox id="transferTransactionCollection1" value="#{account.account.jsfcrud_transform[jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.arrayToList].transferTransactionCollection1}" title="TransferTransactionCollection1" size="6" converter="#{transferTransaction.converter}" >
                        <f:selectItems value="#{transferTransaction.transferTransactionItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="SavingsAccount:"/>
                    <h:selectOneMenu id="savingsAccount" value="#{account.account.savingsAccount}" title="SavingsAccount" >
                        <f:selectItems value="#{savingsAccount.savingsAccountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="CustomerId:"/>
                    <h:selectOneMenu id="customerId" value="#{account.account.customerId}" title="CustomerId" required="true" requiredMessage="The customerId field is required." >
                        <f:selectItems value="#{customer.customerItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{account.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{account.listSetup}" value="Show All Account Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
