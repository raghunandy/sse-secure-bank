<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing OneTimePassword Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing OneTimePassword Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No OneTimePassword Items Found)<br />" rendered="#{oneTimePassword.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{oneTimePassword.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{oneTimePassword.pagingInfo.firstItem + 1}..#{oneTimePassword.pagingInfo.lastItem} of #{oneTimePassword.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{oneTimePassword.prev}" value="Previous #{oneTimePassword.pagingInfo.batchSize}" rendered="#{oneTimePassword.pagingInfo.firstItem >= oneTimePassword.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{oneTimePassword.next}" value="Next #{oneTimePassword.pagingInfo.batchSize}" rendered="#{oneTimePassword.pagingInfo.lastItem + oneTimePassword.pagingInfo.batchSize <= oneTimePassword.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{oneTimePassword.next}" value="Remaining #{oneTimePassword.pagingInfo.itemCount - oneTimePassword.pagingInfo.lastItem}"
                                   rendered="#{oneTimePassword.pagingInfo.lastItem < oneTimePassword.pagingInfo.itemCount && oneTimePassword.pagingInfo.lastItem + oneTimePassword.pagingInfo.batchSize > oneTimePassword.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{oneTimePassword.oneTimePasswordItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Otp"/>
                            </f:facet>
                            <h:outputText value="#{item.otp}"/>
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
                                <h:outputText value="CustomerId"/>
                            </f:facet>
                            <h:outputText value="#{item.customerId}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{oneTimePassword.detailSetup}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{oneTimePassword.editSetup}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{oneTimePassword.remove}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{oneTimePassword.createSetup}" value="New OneTimePassword"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
