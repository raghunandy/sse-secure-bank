<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Editing CheckinAccount</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing CheckinAccount</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="LastDepositAmount:"/>
                    <h:inputText id="lastDepositAmount" value="#{checkinAccount.checkinAccount.lastDepositAmount}" title="LastDepositAmount" />
                    <h:outputText value="AccountNumber:"/>
                    <h:outputText value="#{checkinAccount.checkinAccount.accountNumber}" title="AccountNumber" />
                    <h:outputText value="Account:"/>
                    <h:selectOneMenu id="account" value="#{checkinAccount.checkinAccount.account}" title="Account" required="true" requiredMessage="The account field is required." >
                        <f:selectItems value="#{account.accountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{checkinAccount.edit}" value="Save">
                    <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{checkinAccount.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][checkinAccount.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{checkinAccount.listSetup}" value="Show All CheckinAccount Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
