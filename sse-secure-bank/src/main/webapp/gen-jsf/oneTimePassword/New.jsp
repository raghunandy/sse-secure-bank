<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New OneTimePassword</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New OneTimePassword</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{oneTimePassword.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:inputText id="id" value="#{oneTimePassword.oneTimePassword.id}" title="Id" required="true" requiredMessage="The id field is required." />
                    <h:outputText value="Otp:"/>
                    <h:inputText id="otp" value="#{oneTimePassword.oneTimePassword.otp}" title="Otp" />
                    <h:outputText value="CreationDate (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="creationDate" value="#{oneTimePassword.oneTimePassword.creationDate}" title="CreationDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="CustomerId:"/>
                    <h:selectOneMenu id="customerId" value="#{oneTimePassword.oneTimePassword.customerId}" title="CustomerId" required="true" requiredMessage="The customerId field is required." >
                        <f:selectItems value="#{customer.customerItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{oneTimePassword.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{oneTimePassword.listSetup}" value="Show All OneTimePassword Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
