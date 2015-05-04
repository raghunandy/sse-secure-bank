<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New BankTransaction</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New BankTransaction</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{bankTransaction.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="BankTransactionId:"/>
                    <h:inputText id="bankTransactionId" value="#{bankTransaction.bankTransaction.bankTransactionId}" title="BankTransactionId" required="true" requiredMessage="The bankTransactionId field is required." />
                    <h:outputText value="TransactionType:"/>
                    <h:inputText id="transactionType" value="#{bankTransaction.bankTransaction.transactionType}" title="TransactionType" />
                    <h:outputText value="Date (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="date" value="#{bankTransaction.bankTransaction.date}" title="Date" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="Status:"/>
                    <h:inputText id="status" value="#{bankTransaction.bankTransaction.status}" title="Status" />
                    <h:outputText value="Amount:"/>
                    <h:inputText id="amount" value="#{bankTransaction.bankTransaction.amount}" title="Amount" />
                    <h:outputText value="TransferTransactionCollection:"/>
                    <h:selectManyListbox id="transferTransactionCollection" value="#{bankTransaction.bankTransaction.jsfcrud_transform[jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.arrayToList].transferTransactionCollection}" title="TransferTransactionCollection" size="6" converter="#{transferTransaction.converter}" >
                        <f:selectItems value="#{transferTransaction.transferTransactionItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="AccountNumber:"/>
                    <h:selectOneMenu id="accountNumber" value="#{bankTransaction.bankTransaction.accountNumber}" title="AccountNumber" required="true" requiredMessage="The accountNumber field is required." >
                        <f:selectItems value="#{account.accountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{bankTransaction.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{bankTransaction.listSetup}" value="Show All BankTransaction Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
