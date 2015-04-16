/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.bank.db.access.bean.gen;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sse.bank.db.domain.SavingsAccount;

/**
 *
 * @author Raghunath
 */
@Stateless
public class SavingsAccountFacade extends AbstractFacade<SavingsAccount> {
    @PersistenceContext(unitName = "org.glassfish-samples_sse-secure-bank_war_4.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SavingsAccountFacade() {
        super(SavingsAccount.class);
    }
    
}
