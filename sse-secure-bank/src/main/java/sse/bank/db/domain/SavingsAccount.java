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
    @NamedQuery(name = "SavingsAccount.findByCustomerId", query = "SELECT s FROM SavingsAccount s WHERE s.customerId = :customerId")})
public class SavingsAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interest")
    private Float interest;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customerId")
    private String customerId;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public SavingsAccount() {
    }

    public SavingsAccount(String customerId) {
        this.customerId = customerId;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavingsAccount)) {
            return false;
        }
        SavingsAccount other = (SavingsAccount) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sse.bank.domain.SavingsAccount[ customerId=" + customerId + " ]";
    }
    
}
