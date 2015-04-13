<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New TransactionLog</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TransactionLog</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{transactionLog.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="LogId:"/>
                    <h:inputText id="logId" value="#{transactionLog.transactionLog.logId}" title="LogId" required="true" requiredMessage="The logId field is required." />
                    <h:outputText value="Message:"/>
                    <h:inputText id="message" value="#{transactionLog.transactionLog.message}" title="Message" />
                    <h:outputText value="CreationDate (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="creationDate" value="#{transactionLog.transactionLog.creationDate}" title="CreationDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{transactionLog.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
