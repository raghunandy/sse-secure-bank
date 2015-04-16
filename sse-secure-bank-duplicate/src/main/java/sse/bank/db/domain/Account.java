/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raghunath
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountNumber")
    private String accountNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Float balance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private CheckinAccount checkinAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toAccount")
    private Collection<TransferTransaction> transferTransactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAccount")
    private Collection<TransferTransaction> transferTransactionCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private SavingsAccount savingsAccount;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;

    public Account() {
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public CheckinAccount getCheckinAccount() {
        return checkinAccount;
    }

    public void setCheckinAccount(CheckinAccount checkinAccount) {
        this.checkinAccount = checkinAccount;
    }

    @XmlTransient
    public Collection<TransferTransaction> getTransferTransactionCollection() {
        return transferTransactionCollection;
    }

    public void setTransferTransactionCollection(Collection<TransferTransaction> transferTransactionCollection) {
        this.transferTransactionCollection = transferTransactionCollection;
    }

    @XmlTransient
    public Collection<TransferTransaction> getTransferTransactionCollection1() {
        return transferTransactionCollection1;
    }

    public void setTransferTransactionCollection1(Collection<TransferTransaction> transferTransactionCollection1) {
        this.transferTransactionCollection1 = transferTransactionCollection1;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
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
        hash += (accountNumber != null ? accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.Account[ accountNumber=" + accountNumber + " ]";
    }
    
}
