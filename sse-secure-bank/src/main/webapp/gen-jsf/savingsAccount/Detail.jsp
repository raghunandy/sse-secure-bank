<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>SavingsAccount Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>SavingsAccount Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Interest:"/>
                    <h:outputText value="#{savingsAccount.savingsAccount.interest}" title="Interest" />
                    <h:outputText value="AccountNumber:"/>
                    <h:outputText value="#{savingsAccount.savingsAccount.accountNumber}" title="AccountNumber" />
                    <h:outputText value="Account:"/>
                    <h:panelGroup>
                        <h:outputText value="#{savingsAccount.savingsAccount.account}"/>
                        <h:panelGroup rendered="#{savingsAccount.savingsAccount.account != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="savingsAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.SavingsAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="savingsAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.SavingsAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.destroy}">
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="savingsAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.SavingsAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{savingsAccount.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{savingsAccount.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][savingsAccount.savingsAccount][savingsAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{savingsAccount.createSetup}" value="New SavingsAccount" />
                <br />
                <h:commandLink action="#{savingsAccount.listSetup}" value="Show All SavingsAccount Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
