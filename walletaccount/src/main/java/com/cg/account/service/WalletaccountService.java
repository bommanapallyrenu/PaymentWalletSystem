package com.cg.account.service;

import com.cg.account.entity.Walletaccount;

public interface WalletaccountService {

    Walletaccount addAccount(int userid,Walletaccount wa) ;
    
     Walletaccount deposit(Walletaccount wa,double amount);
     
    double getbalance(int id);

	Walletaccount fundTransfer(int fromaccountid,int toaccountid,double amount);
	
}
