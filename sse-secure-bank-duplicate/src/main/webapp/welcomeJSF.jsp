<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <title>JSP Page</title>
<link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
<link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h1><h:outputText value="JavaServer Faces"/></h1>
                <h:form>
                    <h:commandLink action="#{transferTransaction.listSetup}" value="Show All TransferTransaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transaction.listSetup}" value="Show All Transaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{savingsAccount.listSetup}" value="Show All SavingsAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{oneTimePassword.listSetup}" value="Show All OneTimePassword Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{customerSecurityQuestions.listSetup}" value="Show All CustomerSecurityQuestions Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{customer.listSetup}" value="Show All Customer Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{account.listSetup}" value="Show All Account Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transferTransaction.listSetup}" value="Show All TransferTransaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transaction.listSetup}" value="Show All Transaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{savingsAccount.listSetup}" value="Show All SavingsAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{oneTimePassword.listSetup}" value="Show All OneTimePassword Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{customerSecurityQuestions.listSetup}" value="Show All CustomerSecurityQuestions Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{customer.listSetup}" value="Show All Customer Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{account.listSetup}" value="Show All Account Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transferTransaction.listSetup}" value="Show All TransferTransaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{transaction.listSetup}" value="Show All Transaction Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{savingsAccount.listSetup}" value="Show All SavingsAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{customer.listSetup}" value="Show All Customer Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{account.listSetup}" value="Show All Account Items"/>
                </h:form>

        </body>
    </html>
</f:view>
