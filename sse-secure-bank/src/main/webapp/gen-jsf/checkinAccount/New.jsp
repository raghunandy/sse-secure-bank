<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New CheckinAccount</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New CheckinAccount</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{checkinAccount.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="LastDepositAmount:"/>
                    <h:inputText id="lastDepositAmount" value="#{checkinAccount.checkinAccount.lastDepositAmount}" title="LastDepositAmount" />
                    <h:outputText value="AccountNumber:"/>
                    <h:inputText id="accountNumber" value="#{checkinAccount.checkinAccount.accountNumber}" title="AccountNumber" required="true" requiredMessage="The accountNumber field is required." />
                    <h:outputText value="Account:"/>
                    <h:selectOneMenu id="account" value="#{checkinAccount.checkinAccount.account}" title="Account" required="true" requiredMessage="The account field is required." >
                        <f:selectItems value="#{account.accountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{checkinAccount.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
