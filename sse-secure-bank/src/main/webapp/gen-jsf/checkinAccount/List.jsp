<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing CheckinAccount Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing CheckinAccount Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No CheckinAccount Items Found)<br />" rendered="#{checkinAccount.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{checkinAccount.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{checkinAccount.pagingInfo.firstItem + 1}..#{checkinAccount.pagingInfo.lastItem} of #{checkinAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{checkinAccount.prev}" value="Previous #{checkinAccount.pagingInfo.batchSize}" rendered="#{checkinAccount.pagingInfo.firstItem >= checkinAccount.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{checkinAccount.next}" value="Next #{checkinAccount.pagingInfo.batchSize}" rendered="#{checkinAccount.pagingInfo.lastItem + checkinAccount.pagingInfo.batchSize <= checkinAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{checkinAccount.next}" value="Remaining #{checkinAccount.pagingInfo.itemCount - checkinAccount.pagingInfo.lastItem}"
                                   rendered="#{checkinAccount.pagingInfo.lastItem < checkinAccount.pagingInfo.itemCount && checkinAccount.pagingInfo.lastItem + checkinAccount.pagingInfo.batchSize > checkinAccount.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{checkinAccount.checkinAccountItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="LastDepositAmount"/>
                            </f:facet>
                            <h:outputText value="#{item.lastDepositAmount}"/>
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
                            <h:commandLink value="Show" action="#{checkinAccount.detailSetup}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][checkinAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{checkinAccount.editSetup}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][checkinAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{checkinAccount.remove}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][checkinAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{checkinAccount.createSetup}" value="New CheckinAccount"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
