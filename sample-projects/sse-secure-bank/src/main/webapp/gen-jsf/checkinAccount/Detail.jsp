<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>CheckinAccount Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>CheckinAccount Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="LastDepositAmount:"/>
                    <h:outputText value="#{checkinAccount.checkinAccount.lastDepositAmount}" title="LastDepositAmount" />
                    <h:outputText value="CustomerId:"/>
                    <h:outputText value="#{checkinAccount.checkinAccount.customerId}" title="CustomerId" />
                    <h:outputText value="Account:"/>
                    <h:panelGroup>
                        <h:outputText value="#{checkinAccount.checkinAccount.account}"/>
                        <h:panelGroup rendered="#{checkinAccount.checkinAccount.account != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="checkinAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.jsf.gen.CheckinAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="checkinAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.jsf.gen.CheckinAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.destroy}">
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="checkinAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.jsf.gen.CheckinAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{checkinAccount.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{checkinAccount.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.jsf.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{checkinAccount.createSetup}" value="New CheckinAccount" />
                <br />
                <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items"/>
                <br />

            </h:form>
        </body>
    </html>
</f:view>
