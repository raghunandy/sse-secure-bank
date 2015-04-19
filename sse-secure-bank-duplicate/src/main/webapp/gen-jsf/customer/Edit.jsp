<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Editing Customer</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Customer</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="CustomerId:"/>
                    <h:outputText value="#{customer.customer.customerId}" title="CustomerId" />
                    <h:outputText value="CustomerName:"/>
                    <h:inputText id="customerName" value="#{customer.customer.customerName}" title="CustomerName" />
                    <h:outputText value="Password:"/>
                    <h:inputText id="password" value="#{customer.customer.password}" title="Password" />
                    <h:outputText value="Address:"/>
                    <h:inputText id="address" value="#{customer.customer.address}" title="Address" />
                    <h:outputText value="Phone:"/>
                    <h:inputText id="phone" value="#{customer.customer.phone}" title="Phone" />
                    <h:outputText value="Email:"/>
                    <h:inputText id="email" value="#{customer.customer.email}" title="Email" />
                    <h:outputText value="ResetPasswordToken:"/>
                    <h:inputText id="resetPasswordToken" value="#{customer.customer.resetPasswordToken}" title="ResetPasswordToken" />
                    <h:outputText value="OneTimePasswordCollection:"/>
                    <h:selectManyListbox id="oneTimePasswordCollection" value="#{customer.customer.jsfcrud_transform[jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.arrayToList].oneTimePasswordCollection}" title="OneTimePasswordCollection" size="6" converter="#{oneTimePassword.converter}" >
                        <f:selectItems value="#{oneTimePassword.oneTimePasswordItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="CustomerSecurityQuestions:"/>
                    <h:selectOneMenu id="customerSecurityQuestions" value="#{customer.customer.customerSecurityQuestions}" title="CustomerSecurityQuestions" >
                        <f:selectItems value="#{customerSecurityQuestions.customerSecurityQuestionsItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="AccountCollection:"/>
                    <h:selectManyListbox id="accountCollection" value="#{customer.customer.jsfcrud_transform[jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method.arrayToList].accountCollection}" title="AccountCollection" size="6" converter="#{account.converter}" >
                        <f:selectItems value="#{account.accountItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{customer.edit}" value="Save">
                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{customer.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{customer.listSetup}" value="Show All Customer Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
