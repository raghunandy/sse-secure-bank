<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>TransactionLog Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TransactionLog Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="LogId:"/>
                    <h:outputText value="#{transactionLog.transactionLog.logId}" title="LogId" />
                    <h:outputText value="Message:"/>
                    <h:outputText value="#{transactionLog.transactionLog.message}" title="Message" />
                    <h:outputText value="CreationDate:"/>
                    <h:outputText value="#{transactionLog.transactionLog.creationDate}" title="CreationDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{transactionLog.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transactionLog.transactionLog][transactionLog.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{transactionLog.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transactionLog.transactionLog][transactionLog.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{transactionLog.createSetup}" value="New TransactionLog" />
                <br />
                <h:commandLink action="#{transactionLog.listSetup}" value="Show All TransactionLog Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
