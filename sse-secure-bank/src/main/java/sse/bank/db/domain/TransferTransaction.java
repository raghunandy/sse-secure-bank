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
@Table(name = "transfer_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransferTransaction.findAll", query = "SELECT t FROM TransferTransaction t"),
    @NamedQuery(name = "TransferTransaction.findByAmount", query = "SELECT t FROM TransferTransaction t WHERE t.amount = :amount"),
    @NamedQuery(name = "TransferTransaction.findByTransactionId", query = "SELECT t FROM TransferTransaction t WHERE t.transactionId = :transactionId")})
public class TransferTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transactionId")
    private String transactionId;
    @JoinColumn(name = "transactionId", referencedColumnName = "transactionId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Transaction transaction;
    @JoinColumn(name = "toAccount", referencedColumnName = "accountNumber")
    @ManyToOne(optional = false)
    private Account toAccount;
    @JoinColumn(name = "fromAccount", referencedColumnName = "accountNumber")
    @ManyToOne(optional = false)
    private Account fromAccount;

    public TransferTransaction() {
    }

    public TransferTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransferTransaction)) {
            return false;
        }
        TransferTransaction other = (TransferTransaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.TransferTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
