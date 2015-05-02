/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raghunath
 */
@Entity
@Table(name = "bank_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankTransaction.findAll", query = "SELECT b FROM BankTransaction b"),
    @NamedQuery(name = "BankTransaction.findByTransactionId", query = "SELECT b FROM BankTransaction b WHERE b.transactionId = :transactionId"),
    @NamedQuery(name = "BankTransaction.findByTransactionType", query = "SELECT b FROM BankTransaction b WHERE b.transactionType = :transactionType"),
    @NamedQuery(name = "BankTransaction.findByDate", query = "SELECT b FROM BankTransaction b WHERE b.date = :date"),
    @NamedQuery(name = "BankTransaction.findByStatus", query = "SELECT b FROM BankTransaction b WHERE b.status = :status")})
public class BankTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transactionId")
    private String transactionId;
    @Size(max = 45)
    @Column(name = "transactionType")
    private String transactionType;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private Integer status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bankTransaction")
    private TransferTransaction transferTransaction;

    public BankTransaction() {
    }

    public BankTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public TransferTransaction getTransferTransaction() {
        return transferTransaction;
    }

    public void setTransferTransaction(TransferTransaction transferTransaction) {
        this.transferTransaction = transferTransaction;
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
        if (!(object instanceof BankTransaction)) {
            return false;
        }
        BankTransaction other = (BankTransaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.BankTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
