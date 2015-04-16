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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "CustomerSecurityQuestions.findByQuestionId", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.questionId = :questionId"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByQuestion", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.question = :question"),
    @NamedQuery(name = "CustomerSecurityQuestions.findByCustomerAnswer", query = "SELECT c FROM CustomerSecurityQuestions c WHERE c.customerAnswer = :customerAnswer")})
public class CustomerSecurityQuestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionId")
    private Integer questionId;
    @Size(max = 545)
    @Column(name = "question")
    private String question;
    @Size(max = 2445)
    @Column(name = "customerAnswer")
    private String customerAnswer;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;

    public CustomerSecurityQuestions() {
    }

    public CustomerSecurityQuestions(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCustomerAnswer() {
        return customerAnswer;
    }

    public void setCustomerAnswer(String customerAnswer) {
        this.customerAnswer = customerAnswer;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerSecurityQuestions)) {
            return false;
        }
        CustomerSecurityQuestions other = (CustomerSecurityQuestions) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.CustomerSecurityQuestions[ questionId=" + questionId + " ]";
    }
    
}
