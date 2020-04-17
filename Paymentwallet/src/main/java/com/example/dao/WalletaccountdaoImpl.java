package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Userdata;
import com.example.entity.Walletaccount;


@Repository
public class WalletaccountdaoImpl implements Walletaccountdao{
	
	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Walletaccount addAccount(Walletaccount wa) {
		Walletaccount wal_account=em.merge(wa);
			return wal_account ;
		
	}
	
	
	@Override	
	public Walletaccount deleteaccount(int accountid) {
		Walletaccount wa=em.find(Walletaccount.class,accountid);
		if(wa!=null)
			{
			   em.remove(wa);
			}
        return wa;
	}
		
	@Override
	public Walletaccount deposit(Walletaccount wa, double amount) {
		  Walletaccount wal_account=em.find(Walletaccount.class,wa.getAccountid());
			if(wal_account!=null&amount>0)
			{
				wal_account.setAccountbalance(wal_account.getAccountbalance()+amount);
				wal_account.setStatus("Deposited");
			}
		return wal_account;
	}
	
	
	

}
