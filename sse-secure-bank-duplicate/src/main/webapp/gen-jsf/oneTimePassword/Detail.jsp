<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>OneTimePassword Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>OneTimePassword Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{oneTimePassword.oneTimePassword.id}" title="Id" />
                    <h:outputText value="Otp:"/>
                    <h:outputText value="#{oneTimePassword.oneTimePassword.otp}" title="Otp" />
                    <h:outputText value="CreationDate:"/>
                    <h:outputText value="#{oneTimePassword.oneTimePassword.creationDate}" title="CreationDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="CustomerId:"/>
                    <h:panelGroup>
                        <h:outputText value="#{oneTimePassword.oneTimePassword.customerId}"/>
                        <h:panelGroup rendered="#{oneTimePassword.oneTimePassword.customerId != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customer.detailSetup}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword][oneTimePassword.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="oneTimePassword"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.OneTimePasswordController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customer.editSetup}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword][oneTimePassword.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="oneTimePassword"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.OneTimePasswordController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customer.destroy}">
                                <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword][oneTimePassword.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="oneTimePassword"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.OneTimePasswordController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{oneTimePassword.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword][oneTimePassword.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{oneTimePassword.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][oneTimePassword.oneTimePassword][oneTimePassword.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{oneTimePassword.createSetup}" value="New OneTimePassword" />
                <br />
                <h:commandLink action="#{oneTimePassword.listSetup}" value="Show All OneTimePassword Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
