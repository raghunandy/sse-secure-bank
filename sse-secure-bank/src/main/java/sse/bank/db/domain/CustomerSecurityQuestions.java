/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raghunath
 */
@Entity
@Table(name = "customer_security_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerSecurityQuestions.findAll", query = "SELECT c FROM CustomerSecurityQuestions c"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByCustomerId", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByQuestionOne", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.questionOne = :questionOne"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByAnswerOne", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.answerOne = :answerOne"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByQuestionTwo", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.questionTwo = :questionTwo"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByAnswerTwo", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.answerTwo = :answerTwo"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByQuestionThree", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.questionThree = :questionThree"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByAnswerThree", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.answerThree = :answerThree")})
public class CustomerSecurityQuestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customerId")
    private String customerId;
    @Size(max = 545)
    @Column(name = "questionOne")
    private String questionOne;
    @Size(max = 545)
    @Column(name = "answerOne")
    private String answerOne;
    @Size(max = 545)
    @Column(name = "questionTwo")
    private String questionTwo;
    @Size(max = 545)
    @Column(name = "answerTwo")
    private String answerTwo;
    @Size(max = 545)
    @Column(name = "questionThree")
    private String questionThree;
    @Size(max = 45)
    @Column(name = "answerThree")
    private String answerThree;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerSecurityQuestions() {
    }

    public CustomerSecurityQuestions(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerSecurityQuestions)) {
            return false;
        }
        CustomerSecurityQuestions other = (CustomerSecurityQuestions) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.CustomerSecurityQuestions[ customerId=" + customerId + " ]";
    }
    
}
