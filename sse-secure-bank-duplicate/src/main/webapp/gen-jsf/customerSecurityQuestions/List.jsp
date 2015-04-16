<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Listing CustomerSecurityQuestions Items</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank-duplicate/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing CustomerSecurityQuestions Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No CustomerSecurityQuestions Items Found)<br />" rendered="#{customerSecurityQuestions.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{customerSecurityQuestions.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{customerSecurityQuestions.pagingInfo.firstItem + 1}..#{customerSecurityQuestions.pagingInfo.lastItem} of #{customerSecurityQuestions.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{customerSecurityQuestions.prev}" value="Previous #{customerSecurityQuestions.pagingInfo.batchSize}" rendered="#{customerSecurityQuestions.pagingInfo.firstItem >= customerSecurityQuestions.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{customerSecurityQuestions.next}" value="Next #{customerSecurityQuestions.pagingInfo.batchSize}" rendered="#{customerSecurityQuestions.pagingInfo.lastItem + customerSecurityQuestions.pagingInfo.batchSize <= customerSecurityQuestions.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{customerSecurityQuestions.next}" value="Remaining #{customerSecurityQuestions.pagingInfo.itemCount - customerSecurityQuestions.pagingInfo.lastItem}"
                                   rendered="#{customerSecurityQuestions.pagingInfo.lastItem < customerSecurityQuestions.pagingInfo.itemCount && customerSecurityQuestions.pagingInfo.lastItem + customerSecurityQuestions.pagingInfo.batchSize > customerSecurityQuestions.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{customerSecurityQuestions.customerSecurityQuestionsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customerSecurityQuestions.editSetup}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customerSecurityQuestions.remove}">
                                <f:param name="jsfcrud.currentCustomerSecurityQuestions" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][customerSecurityQuestions.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{customerSecurityQuestions.createSetup}" value="New CustomerSecurityQuestions"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
