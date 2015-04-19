<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>New CustomerSecurityQuestions</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New CustomerSecurityQuestions</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{customerSecurityQuestions.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="CustomerId:"/>
                    <h:inputText id="customerId" value="#{customerSecurityQuestions.customerSecurityQuestions.customerId}" title="CustomerId" required="true" requiredMessage="The customerId field is required." />
                    <h:outputText value="QuestionOne:"/>
                    <h:inputText id="questionOne" value="#{customerSecurityQuestions.customerSecurityQuestions.questionOne}" title="QuestionOne" />
                    <h:outputText value="AnswerOne:"/>
                    <h:inputText id="answerOne" value="#{customerSecurityQuestions.customerSecurityQuestions.answerOne}" title="AnswerOne" />
                    <h:outputText value="QuestionTwo:"/>
                    <h:inputText id="questionTwo" value="#{customerSecurityQuestions.customerSecurityQuestions.questionTwo}" title="QuestionTwo" />
                    <h:outputText value="AnswerTwo:"/>
                    <h:inputText id="answerTwo" value="#{customerSecurityQuestions.customerSecurityQuestions.answerTwo}" title="AnswerTwo" />
                    <h:outputText value="QuestionThree:"/>
                    <h:inputText id="questionThree" value="#{customerSecurityQuestions.customerSecurityQuestions.questionThree}" title="QuestionThree" />
                    <h:outputText value="AnswerThree:"/>
                    <h:inputText id="answerThree" value="#{customerSecurityQuestions.customerSecurityQuestions.answerThree}" title="AnswerThree" />
                    <h:outputText value="Customer:"/>
                    <h:selectOneMenu id="customer" value="#{customerSecurityQuestions.customerSecurityQuestions.customer}" title="Customer" required="true" requiredMessage="The customer field is required." >
                        <f:selectItems value="#{customer.customerItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{customerSecurityQuestions.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{customerSecurityQuestions.listSetup}" value="Show All CustomerSecurityQuestions Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
