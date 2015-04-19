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
                    <h:outputText value="CustomerId:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.customerId}" title="CustomerId" />
                    <h:outputText value="QuestionOne:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.questionOne}" title="QuestionOne" />
                    <h:outputText value="AnswerOne:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.answerOne}" title="AnswerOne" />
                    <h:outputText value="QuestionTwo:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.questionTwo}" title="QuestionTwo" />
                    <h:outputText value="AnswerTwo:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.answerTwo}" title="AnswerTwo" />
                    <h:outputText value="QuestionThree:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.questionThree}" title="QuestionThree" />
                    <h:outputText value="AnswerThree:"/>
                    <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.answerThree}" title="AnswerThree" />
                    <h:outputText value="Customer:"/>
                    <h:panelGroup>
                        <h:outputText value="#{customerSecurityQuestions.customerSecurityQuestions.customer}"/>
                        <h:panelGroup rendered="#{customerSecurityQuestions.customerSecurityQuestions.customer != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customer.detailSetup}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customer][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="customerSecurityQuestions"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerSecurityQuestionsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customer.editSetup}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customer][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="customerSecurityQuestions"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerSecurityQuestionsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customer.destroy}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customerSecurityQuestions.customerSecurityQuestions.customer][customer.converter].jsfcrud_invoke}"/>
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
