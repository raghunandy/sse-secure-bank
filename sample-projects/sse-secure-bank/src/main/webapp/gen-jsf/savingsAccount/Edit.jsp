<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Editing SavingsAccount</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing SavingsAccount</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Interest:"/>
                    <h:inputText id="interest" value="#{savingsAccount.savingsAccount.interest}" title="Interest" />
                    <h:outputText value="CustomerId:"/>
                    <h:outputText value="#{savingsAccount.savingsAccount.customerId}" title="CustomerId" />
                    <h:outputText value="Account:"/>
                    <h:selectOneMenu id="account" value="#{savingsAccount.savingsAccount.account}" title="Account" required="true" requiredMessage="The account field is required." >
                        <f:selectItems value="#{account.accountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{savingsAccount.edit}" value="Save">
                    <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{savingsAccount.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{savingsAccount.listSetup}" value="Show All SavingsAccount Items" immediate="true"/>
                <br />

            </h:form>
        </body>
    </html>
</f:view>
