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
                    <h:outputText value="BankTransactionId:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.bankTransactionId}" title="BankTransactionId" />
                    <h:outputText value="TransactionType:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.transactionType}" title="TransactionType" />
                    <h:outputText value="Date:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.date}" title="Date" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="Status:"/>
                    <h:outputText value="#{bankTransaction.bankTransaction.status}" title="Status" />

                    <h:outputText value="TransferTransactionCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty bankTransaction.bankTransaction.transferTransactionCollection}" value="(No Items)"/>
                        <h:dataTable value="#{bankTransaction.bankTransaction.transferTransactionCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty bankTransaction.bankTransaction.transferTransactionCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Amount"/>
                                </f:facet>
                                <h:outputText value="#{item.amount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TransactionId"/>
                                </f:facet>
                                <h:outputText value="#{item.transactionId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ToAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.toAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FromAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.fromAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="BankTransactionId"/>
                                </f:facet>
                                <h:outputText value="#{item.bankTransactionId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{transferTransaction.detailSetup}">
                                    <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="bankTransaction" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{transferTransaction.editSetup}">
                                    <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="bankTransaction" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{transferTransaction.destroy}">
                                    <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][bankTransaction.bankTransaction][bankTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="bankTransaction" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.BankTransactionController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
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
