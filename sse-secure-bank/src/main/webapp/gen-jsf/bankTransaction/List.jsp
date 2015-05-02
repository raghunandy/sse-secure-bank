<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing BankTransaction Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing BankTransaction Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No BankTransaction Items Found)<br />" rendered="#{bankTransaction.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{bankTransaction.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{bankTransaction.pagingInfo.firstItem + 1}..#{bankTransaction.pagingInfo.lastItem} of #{bankTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{bankTransaction.prev}" value="Previous #{bankTransaction.pagingInfo.batchSize}" rendered="#{bankTransaction.pagingInfo.firstItem >= bankTransaction.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{bankTransaction.next}" value="Next #{bankTransaction.pagingInfo.batchSize}" rendered="#{bankTransaction.pagingInfo.lastItem + bankTransaction.pagingInfo.batchSize <= bankTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{bankTransaction.next}" value="Remaining #{bankTransaction.pagingInfo.itemCount - bankTransaction.pagingInfo.lastItem}"
                                   rendered="#{bankTransaction.pagingInfo.lastItem < bankTransaction.pagingInfo.itemCount && bankTransaction.pagingInfo.lastItem + bankTransaction.pagingInfo.batchSize > bankTransaction.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{bankTransaction.bankTransactionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="TransactionId"/>
                            </f:facet>
                            <h:outputText value="#{item.transactionId}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="TransactionType"/>
                            </f:facet>
                            <h:outputText value="#{item.transactionType}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Date"/>
                            </f:facet>
                            <h:outputText value="#{item.date}">
                                <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Status"/>
                            </f:facet>
                            <h:outputText value="#{item.status}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="TransferTransaction"/>
                            </f:facet>
                            <h:outputText value="#{item.transferTransaction}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{bankTransaction.detailSetup}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][bankTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{bankTransaction.editSetup}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][bankTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{bankTransaction.remove}">
                                <f:param name="jsfcrud.currentBankTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][bankTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{bankTransaction.createSetup}" value="New BankTransaction"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
