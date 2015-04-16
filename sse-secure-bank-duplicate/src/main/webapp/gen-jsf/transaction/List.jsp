<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing Transaction Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Transaction Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Transaction Items Found)<br />" rendered="#{transaction.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{transaction.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{transaction.pagingInfo.firstItem + 1}..#{transaction.pagingInfo.lastItem} of #{transaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transaction.prev}" value="Previous #{transaction.pagingInfo.batchSize}" rendered="#{transaction.pagingInfo.firstItem >= transaction.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{transaction.next}" value="Next #{transaction.pagingInfo.batchSize}" rendered="#{transaction.pagingInfo.lastItem + transaction.pagingInfo.batchSize <= transaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transaction.next}" value="Remaining #{transaction.pagingInfo.itemCount - transaction.pagingInfo.lastItem}"
                                   rendered="#{transaction.pagingInfo.lastItem < transaction.pagingInfo.itemCount && transaction.pagingInfo.lastItem + transaction.pagingInfo.batchSize > transaction.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{transaction.transactionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                            <h:commandLink value="Show" action="#{transaction.detailSetup}">
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{transaction.editSetup}">
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{transaction.remove}">
                                <f:param name="jsfcrud.currentTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{transaction.createSetup}" value="New Transaction"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
