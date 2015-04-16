<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>CustomerSecurityQuestions Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>CustomerSecurityQuestions Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="QuestionId:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.questionId}" title="QuestionId" />
                    <h:outputText value="Question:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.question}" title="Question" />
                    <h:outputText value="CustomerAnswer:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.customerAnswer}" title="CustomerAnswer" />
                    <h:outputText value="CustomerId:"/>
                    <h:panelGroup>
                        <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.customerId}"/>
                        <h:panelGroup rendered="#{customerSecurityQuestions.customerSecurityQuestions.customerId != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customer.detailSetup}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="customerSecurityQuestions"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerSecurityQuestionsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customer.editSetup}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="customerSecurityQuestions"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerSecurityQuestionsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customer.destroy}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="customerSecurityQuestions"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerSecurityQuestionsController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{customerSecurityQuestions.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{customerSecurityQuestions.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{customerSecurityQuestions.createSetup}" value="New CustomerSecurityQuestions" />
                <br />
                <h:commandLink action="#{customerSecurityQuestions.listSetup}" value="Show All CustomerSecurityQuestions Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
