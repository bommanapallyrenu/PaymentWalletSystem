package com.example.service;

import com.example.entity.Walletaccount;

public interface WalletaccountService {

    Walletaccount addAccount(Walletaccount wa) ;
	
    Walletaccount deleteaccount(int accountid);
    
    
     Walletaccount deposit(Walletaccount wa,double amount);
     
    

	
	
}
