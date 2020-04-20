package com.example.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;


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
		  long transactionID=new Random().nextInt(100000);
			if(wal_account!=null&amount>0)
			{
				Wallettransaction wt=new Wallettransaction();
				wt.setAccountid(wa.getAccountid());
				wt.setAccountbalance(wal_account.getAccountbalance()+amount);
				wt.setAmount(amount);
				wt.setDescription("Deposited");
				//wt.setTransactionDate(new Date());
				wt.setTransactionID(transactionID);
				em.merge(wt);
				wal_account.setAccountbalance(wal_account.getAccountbalance()+amount);
				wal_account.setStatus("Deposited");
				
				return wal_account;
			}
			else
			{
				return null;
			}
	}
	
	@Override
      public Walletaccount fundTransfer(int fromaccountid, int toaccountid, double amount) {
    	  Walletaccount wal_account1=em.find(Walletaccount.class,fromaccountid);
    	  Walletaccount wal_account2=em.find(Walletaccount.class,toaccountid);
    	  long transactionID=new Random().nextInt(100000);
    	  if((wal_account1!=null)&(wal_account2!=null))
    	  {
    		  Wallettransaction wt=new Wallettransaction();
				wt.setAccountid(fromaccountid);
				wt.setAccountbalance(wal_account1.getAccountbalance()-amount);
				wt.setAmount(amount);
				wt.setDescription("Transfering money");
				//wt.setTransactionDate(new Date());
				wt.setTransactionID(transactionID);
				em.merge(wt);
    		  
    		  wal_account1.setAccountbalance(wal_account1.getAccountbalance()-amount);
    		  wal_account1.setStatus("withdrawn(transfered to other account)");
    		  wal_account2.setAccountbalance(wal_account2.getAccountbalance()+amount);
    		  wal_account2.setStatus("Deposited from other account");
    		  return wal_account1;
    	  }
    	  else{
    		  return null;  
    	  }
	 }
	


	@Override
	public double getbalance(int id) {
		Walletaccount wal_account=em.find(Walletaccount.class,id);
		double balance = 0;
		if(wal_account!=null)
		{
		      balance=wal_account.getAccountbalance();
		}
		return balance;
	}
	
}
