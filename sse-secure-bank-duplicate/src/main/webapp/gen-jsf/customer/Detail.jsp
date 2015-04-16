<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Customer Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Customer Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="CustomerId:"/>
                    <h:outputText value="#{customer.customer.customerId}" title="CustomerId" />
                    <h:outputText value="CustomerName:"/>
                    <h:outputText value="#{customer.customer.customerName}" title="CustomerName" />
                    <h:outputText value="Password:"/>
                    <h:outputText value="#{customer.customer.password}" title="Password" />
                    <h:outputText value="Address:"/>
                    <h:outputText value="#{customer.customer.address}" title="Address" />
                    <h:outputText value="Phone:"/>
                    <h:outputText value="#{customer.customer.phone}" title="Phone" />
                    <h:outputText value="Email:"/>
                    <h:outputText value="#{customer.customer.email}" title="Email" />
                    <h:outputText value="ResetPasswordToken:"/>
                    <h:outputText value="#{customer.customer.resetPasswordToken}" title="ResetPasswordToken" />

                    <h:outputText value="OneTimePasswordCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty customer.customer.oneTimePasswordCollection}" value="(No Items)"/>
                        <h:dataTable value="#{customer.customer.oneTimePasswordCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty customer.customer.oneTimePasswordCollection}">
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
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{oneTimePassword.editSetup}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{oneTimePassword.destroy}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOneTimePassword" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][oneTimePassword.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="CustomerSecurityQuestionsCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty customer.customer.customerSecurityQuestionsCollection}" value="(No Items)"/>
                        <h:dataTable value="#{customer.customer.customerSecurityQuestionsCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty customer.customer.customerSecurityQuestionsCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="QuestionId"/>
                                </f:facet>
                                <h:outputText value="#{item.questionId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Question"/>
                                </f:facet>
                                <h:outputText value="#{item.question}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CustomerAnswer"/>
                                </f:facet>
                                <h:outputText value="#{item.customerAnswer}"/>
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
                                <h:commandLink value="Show" action="#{customerSecurityQuestions.detailSetup}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{customerSecurityQuestions.editSetup}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{customerSecurityQuestions.destroy}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="AccountCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty customer.customer.accountCollection}" value="(No Items)"/>
                        <h:dataTable value="#{customer.customer.accountCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty customer.customer.accountCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="AccountNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.accountNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Balance"/>
                                </f:facet>
                                <h:outputText value="#{item.balance}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CheckinAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.checkinAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="SavingsAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.savingsAccount}"/>
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
                                <h:commandLink value="Show" action="#{account.detailSetup}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{account.editSetup}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{account.destroy}">
                                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="customer" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.CustomerController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{customer.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{customer.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][customer.customer][customer.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{customer.createSetup}" value="New Customer" />
                <br />
                <h:commandLink action="#{customer.listSetup}" value="Show All Customer Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
