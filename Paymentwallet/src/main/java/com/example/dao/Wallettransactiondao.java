package com.example.dao;

import java.util.List;

import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;

public interface Wallettransactiondao {
	
List<Wallettransaction> getAllTransaction();
	
	List<Wallettransaction> getAllTransactionById(Walletaccount wa);

}
