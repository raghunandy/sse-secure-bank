<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing SavingsAccount Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing SavingsAccount Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No SavingsAccount Items Found)<br />" rendered="#{savingsAccount.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{savingsAccount.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{savingsAccount.pagingInfo.firstItem + 1}..#{savingsAccount.pagingInfo.lastItem} of #{savingsAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{savingsAccount.prev}" value="Previous #{savingsAccount.pagingInfo.batchSize}" rendered="#{savingsAccount.pagingInfo.firstItem >= savingsAccount.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{savingsAccount.next}" value="Next #{savingsAccount.pagingInfo.batchSize}" rendered="#{savingsAccount.pagingInfo.lastItem + savingsAccount.pagingInfo.batchSize <= savingsAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{savingsAccount.next}" value="Remaining #{savingsAccount.pagingInfo.itemCount - savingsAccount.pagingInfo.lastItem}"
                                   rendered="#{savingsAccount.pagingInfo.lastItem < savingsAccount.pagingInfo.itemCount && savingsAccount.pagingInfo.lastItem + savingsAccount.pagingInfo.batchSize > savingsAccount.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{savingsAccount.savingsAccountItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Interest"/>
                            </f:facet>
                            <h:outputText value="#{item.interest}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="AccountNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.accountNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Account"/>
                            </f:facet>
                            <h:outputText value="#{item.account}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{savingsAccount.detailSetup}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][savingsAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{savingsAccount.editSetup}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][savingsAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{savingsAccount.remove}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][savingsAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{savingsAccount.createSetup}" value="New SavingsAccount"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
