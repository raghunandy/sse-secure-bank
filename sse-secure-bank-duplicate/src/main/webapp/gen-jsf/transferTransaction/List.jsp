<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing TransferTransaction Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TransferTransaction Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TransferTransaction Items Found)<br />" rendered="#{transferTransaction.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{transferTransaction.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{transferTransaction.pagingInfo.firstItem + 1}..#{transferTransaction.pagingInfo.lastItem} of #{transferTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transferTransaction.prev}" value="Previous #{transferTransaction.pagingInfo.batchSize}" rendered="#{transferTransaction.pagingInfo.firstItem >= transferTransaction.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{transferTransaction.next}" value="Next #{transferTransaction.pagingInfo.batchSize}" rendered="#{transferTransaction.pagingInfo.lastItem + transferTransaction.pagingInfo.batchSize <= transferTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transferTransaction.next}" value="Remaining #{transferTransaction.pagingInfo.itemCount - transferTransaction.pagingInfo.lastItem}"
                                   rendered="#{transferTransaction.pagingInfo.lastItem < transferTransaction.pagingInfo.itemCount && transferTransaction.pagingInfo.lastItem + transferTransaction.pagingInfo.batchSize > transferTransaction.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{transferTransaction.transferTransactionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <h:outputText value="Transaction"/>
                            </f:facet>
                            <h:outputText value="#{item.transaction}"/>
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
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{transferTransaction.detailSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{transferTransaction.editSetup}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{transferTransaction.remove}">
                                <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{transferTransaction.createSetup}" value="New TransferTransaction"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
