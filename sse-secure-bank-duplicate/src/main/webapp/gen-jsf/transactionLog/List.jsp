<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing TransactionLog Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TransactionLog Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TransactionLog Items Found)<br />" rendered="#{transactionLog.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{transactionLog.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{transactionLog.pagingInfo.firstItem + 1}..#{transactionLog.pagingInfo.lastItem} of #{transactionLog.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transactionLog.prev}" value="Previous #{transactionLog.pagingInfo.batchSize}" rendered="#{transactionLog.pagingInfo.firstItem >= transactionLog.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{transactionLog.next}" value="Next #{transactionLog.pagingInfo.batchSize}" rendered="#{transactionLog.pagingInfo.lastItem + transactionLog.pagingInfo.batchSize <= transactionLog.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{transactionLog.next}" value="Remaining #{transactionLog.pagingInfo.itemCount - transactionLog.pagingInfo.lastItem}"
                                   rendered="#{transactionLog.pagingInfo.lastItem < transactionLog.pagingInfo.itemCount && transactionLog.pagingInfo.lastItem + transactionLog.pagingInfo.batchSize > transactionLog.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{transactionLog.transactionLogItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="LogId"/>
                            </f:facet>
                            <h:outputText value="#{item.logId}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Message"/>
                            </f:facet>
                            <h:outputText value="#{item.message}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CreationDate"/>
                            </f:facet>
                            <h:outputText value="#{item.creationDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{transactionLog.detailSetup}">
                                <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transactionLog.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{transactionLog.editSetup}">
                                <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transactionLog.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{transactionLog.remove}">
                                <f:param name="jsfcrud.currentTransactionLog" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transactionLog.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{transactionLog.createSetup}" value="New TransactionLog"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
