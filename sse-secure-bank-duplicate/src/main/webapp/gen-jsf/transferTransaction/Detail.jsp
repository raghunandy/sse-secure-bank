<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>TransferTransaction Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TransferTransaction Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Amount:"/>
                    <h:outputText value="#{transferTransaction.transferTransaction.amount}" title="Amount" />
                    <h:outputText value="TransactionId:"/>
                    <h:outputText value="#{transferTransaction.transferTransaction.transactionId}" title="TransactionId" />
                    <h:outputText value="Transaction:"/>
                    <h:panelGroup>
                        <h:outputText value="#{transferTransaction.transferTransaction.transaction}"/>
                        <h:panelGroup rendered="#{transferTransaction.transferTransaction.transaction != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{transaction.detailSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.transaction][transaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{transaction.editSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.transaction][transaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{transaction.destroy}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.transaction][transaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="ToAccount:"/>
                    <h:panelGroup>
                        <h:outputText value="#{transferTransaction.transferTransaction.toAccount}"/>
                        <h:panelGroup rendered="#{transferTransaction.transferTransaction.toAccount != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.toAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.toAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.destroy}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.toAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="FromAccount:"/>
                    <h:panelGroup>
                        <h:outputText value="#{transferTransaction.transferTransaction.fromAccount}"/>
                        <h:panelGroup rendered="#{transferTransaction.transferTransaction.fromAccount != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.fromAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.fromAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.destroy}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction.fromAccount][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="transferTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.TransferTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{transferTransaction.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{transferTransaction.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][transferTransaction.transferTransaction][transferTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{transferTransaction.createSetup}" value="New TransferTransaction" />
                <br />
                <h:commandLink action="#{transferTransaction.listSetup}" value="Show All TransferTransaction Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
