<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Editing TransactionLog</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TransactionLog</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="LogId:"/>
                    <h:outputText value="#{transactionLog.transactionLog.logId}" title="LogId" />
                    <h:outputText value="Message:"/>
                    <h:inputText id="message" value="#{transactionLog.transactionLog.message}" title="Message" />
                    <h:outputText value="CreationDate (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="creationDate" value="#{transactionLog.transactionLog.creationDate}" title="CreationDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{transactionLog.edit}" value="Save">
                    <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transactionLog.transactionLog][transactionLog.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{transactionLog.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transactionLog.transactionLog][transactionLog.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
