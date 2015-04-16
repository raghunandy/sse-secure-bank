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
                    <h:outputText value="QuestionId:"/>
                    <h:inputText id="questionId" value="#{customerSecurityQuestions.customerSecurityQuestions.questionId}" title="QuestionId" required="true" requiredMessage="The questionId field is required." />
                    <h:outputText value="Question:"/>
                    <h:inputText id="question" value="#{customerSecurityQuestions.customerSecurityQuestions.question}" title="Question" />
                    <h:outputText value="CustomerAnswer:"/>
                    <h:inputText id="customerAnswer" value="#{customerSecurityQuestions.customerSecurityQuestions.customerAnswer}" title="CustomerAnswer" />
                    <h:outputText value="CustomerId:"/>
                    <h:selectOneMenu id="customerId" value="#{customerSecurityQuestions.customerSecurityQuestions.customerId}" title="CustomerId" required="true" requiredMessage="The customerId field is required." >
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
