/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raghunath
 */
@Entity
@Table(name = "bank_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankTransaction.findAll", query = "SELECT b FROM BankTransaction b"),
    @NamedQuery(name = "BankTransaction.findByBankTransactionId", query = "SELECT b FROM BankTransaction b WHERE b.bankTransactionId = :bankTransactionId"),
    @NamedQuery(name = "BankTransaction.findByTransactionType", query = "SELECT b FROM BankTransaction b WHERE b.transactionType = :transactionType"),
    @NamedQuery(name = "BankTransaction.findByDate", query = "SELECT b FROM BankTransaction b WHERE b.date = :date"),
    @NamedQuery(name = "BankTransaction.findByStatus", query = "SELECT b FROM BankTransaction b WHERE b.status = :status"),
    @NamedQuery(name = "BankTransaction.findByAmount", query = "SELECT b FROM BankTransaction b WHERE b.amount = :amount")})
public class BankTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bankTransactionId")
    private String bankTransactionId;
    @Size(max = 45)
    @Column(name = "transactionType")
    private String transactionType;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private Integer status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
    @OneToMany(mappedBy = "bankTransactionId")
    private Collection<TransferTransaction> transferTransactionCollection;
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
    @ManyToOne(optional = false)
    private Account accountNumber;

    public BankTransaction() {
    }

    public BankTransaction(String bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(String bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<TransferTransaction> getTransferTransactionCollection() {
        return transferTransactionCollection;
    }

    public void setTransferTransactionCollection(Collection<TransferTransaction> transferTransactionCollection) {
        this.transferTransactionCollection = transferTransactionCollection;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankTransactionId != null ? bankTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankTransaction)) {
            return false;
        }
        BankTransaction other = (BankTransaction) object;
        if ((this.bankTransactionId == null && other.bankTransactionId != null) || (this.bankTransactionId != null && !this.bankTransactionId.equals(other.bankTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.BankTransaction[ bankTransactionId=" + bankTransactionId + " ]";
    }
    
}
