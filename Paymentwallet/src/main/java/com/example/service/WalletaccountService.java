package com.example.service;

import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;

public interface WalletaccountService {

    Walletaccount addAccount(Walletaccount wa) ;
	
    Walletaccount deleteaccount(int accountid);
    
    
     Walletaccount deposit(Walletaccount wa,double amount);
     
    double getbalance(int id);

	Walletaccount fundTransfer(int fromaccountid,int toaccountid,double amount);
	
}
