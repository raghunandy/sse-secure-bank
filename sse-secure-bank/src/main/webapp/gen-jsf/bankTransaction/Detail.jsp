<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>BankTransaction Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>BankTransaction Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="TransactionId:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.transactionId}" title="TransactionId" />
                    <h:outputText value="TransactionType:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.transactionType}" title="TransactionType" />
                    <h:outputText value="Date:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.date}" title="Date" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="Status:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.status}" title="Status" />
                    <h:outputText value="TransferTransaction:"/>
                    <h:panelGroup>
                        <h:outputText value="#{bankTransaction.bankTransaction.transferTransaction}"/>
                        <h:panelGroup rendered="#{bankTransaction.bankTransaction.transferTransaction != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{transferTransaction.detailSetup}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="bankTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{transferTransaction.editSetup}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="bankTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{transferTransaction.destroy}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="bankTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{bankTransaction.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{bankTransaction.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{bankTransaction.createSetup}" value="New BankTransaction" />
                <br />
                <h:commandLink action="#{bankTransaction.listSetup}" value="Show All BankTransaction Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
