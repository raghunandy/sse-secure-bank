<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing Account Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Account Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Account Items Found)<br />" rendered="#{account.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{account.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{account.pagingInfo.firstItem + 1}..#{account.pagingInfo.lastItem} of #{account.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{account.prev}" value="Previous #{account.pagingInfo.batchSize}" rendered="#{account.pagingInfo.firstItem >= account.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{account.next}" value="Next #{account.pagingInfo.batchSize}" rendered="#{account.pagingInfo.lastItem + account.pagingInfo.batchSize <= account.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{account.next}" value="Remaining #{account.pagingInfo.itemCount - account.pagingInfo.lastItem}"
                                   rendered="#{account.pagingInfo.lastItem < account.pagingInfo.itemCount && account.pagingInfo.lastItem + account.pagingInfo.batchSize > account.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{account.accountItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="AccountNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.accountNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Balance"/>
                            </f:facet>
                            <h:outputText value="#{item.balance}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CheckinAccount"/>
                            </f:facet>
                            <h:outputText value="#{item.checkinAccount}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="SavingsAccount"/>
                            </f:facet>
                            <h:outputText value="#{item.savingsAccount}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CustomerId"/>
                            </f:facet>
                            <h:outputText value="#{item.customerId}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.remove}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{account.createSetup}" value="New Account"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
