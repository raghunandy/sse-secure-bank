<%@page contentType="text/html"%>
<%@page pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Account Detail</title>
            <link rel="stylesheet" type="text/css" href="/sse-secure-bank/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Account Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="AccountNumber:"/>
                    <h:outputText value="#{account.account.accountNumber}" title="AccountNumber" />
                    <h:outputText value="Balance:"/>
                    <h:outputText value="#{account.account.balance}" title="Balance" />
                    <h:outputText value="CheckinAccount:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.checkinAccount}"/>
                        <h:panelGroup rendered="#{account.account.checkinAccount != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{checkinAccount.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{checkinAccount.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{checkinAccount.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCheckinAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.checkinAccount][checkinAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="SavingsAccount:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.savingsAccount}"/>
                        <h:panelGroup rendered="#{account.account.savingsAccount != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{savingsAccount.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{savingsAccount.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{savingsAccount.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentSavingsAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.savingsAccount][savingsAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="CustomerId:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.customerId}"/>
                        <h:panelGroup rendered="#{account.account.customerId != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{customer.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{customer.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{customer.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentCustomer" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.customerId][customer.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="TransferTransactionCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.transferTransactionCollection}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.transferTransactionCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.transferTransactionCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Amount"/>
                                </f:facet>
                                <h:outputText value="#{item.amount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TransactionId"/>
                                </f:facet>
                                <h:outputText value="#{item.transactionId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Transaction"/>
                                </f:facet>
                                <h:outputText value="#{item.transaction}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ToAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.toAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FromAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.fromAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{transferTransaction.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{transferTransaction.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{transferTransaction.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="TransferTransactionCollection1:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.transferTransactionCollection1}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.transferTransactionCollection1}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.transferTransactionCollection1}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Amount"/>
                                </f:facet>
                                <h:outputText value="#{item.amount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TransactionId"/>
                                </f:facet>
                                <h:outputText value="#{item.transactionId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Transaction"/>
                                </f:facet>
                                <h:outputText value="#{item.transaction}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ToAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.toAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FromAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.fromAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{transferTransaction.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{transferTransaction.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{transferTransaction.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTransferTransaction" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][transferTransaction.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="sse.bank.db.ui.gen.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{account.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{account.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['sse.bank.db.ui.gen.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{account.createSetup}" value="New Account" />
                <br />
                <h:commandLink action="#{account.listSetup}" value="Show All Account Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
