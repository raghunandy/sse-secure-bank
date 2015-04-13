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
@Table(name = "savings_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SavingsAccount.findAll", query = "SELECT s FROM SavingsAccount s"),
    @NamedQuery(name = "SavingsAccount.findByInterest", query = "SELECT s FROM SavingsAccount s WHERE s.interest = :interest"),
    @NamedQuery(name = "SavingsAccount.findByAccountNumber", query = "SELECT s FROM SavingsAccount s WHERE s.accountNumber = :accountNumber")})
public class SavingsAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interest")
    private Float interest;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountNumber")
    private String accountNumber;
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        if (!(object instanceof SavingsAccount)) {
            return false;
        }
        SavingsAccount other = (SavingsAccount) object;
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.db.domain.SavingsAccount[ accountNumber=" + accountNumber + " ]";
    }
    
}
