<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New Transaction</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Transaction</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{transaction.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="TransactionId:"/>
                    <h:inputText id="transactionId" value="#{transaction.transaction.transactionId}" title="TransactionId" required="true" requiredMessage="The transactionId field is required." />
                    <h:outputText value="TransactionType:"/>
                    <h:inputText id="transactionType" value="#{transaction.transaction.transactionType}" title="TransactionType" />
                    <h:outputText value="Date (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="date" value="#{transaction.transaction.date}" title="Date" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="Status:"/>
                    <h:inputText id="status" value="#{transaction.transaction.status}" title="Status" />
                    <h:outputText value="TransferTransaction:"/>
                    <h:selectOneMenu id="transferTransaction" value="#{transaction.transaction.transferTransaction}" title="TransferTransaction" >
                        <f:selectItems value="#{transferTransaction.transferTransactionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{transaction.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{transaction.listSetup}" value="Show All Transaction Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
