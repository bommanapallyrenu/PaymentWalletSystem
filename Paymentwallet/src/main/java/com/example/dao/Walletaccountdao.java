package com.example.dao;

import com.example.entity.Walletaccount;

public interface Walletaccountdao {
	
	public Walletaccount addAccount(Walletaccount wa) ;
	
	public Walletaccount deleteaccount(int accountid);
	
	
	public Walletaccount deposit(Walletaccount wa,double amount);
	

}
