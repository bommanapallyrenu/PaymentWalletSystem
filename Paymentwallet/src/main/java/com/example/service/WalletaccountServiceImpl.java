package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDaoImpl;
import com.example.dao.WalletaccountdaoImpl;
import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;



@Service
@Transactional
public class WalletaccountServiceImpl implements WalletaccountService{
	
	@Autowired
	WalletaccountdaoImpl dao;


	@Override
	public Walletaccount addAccount(Walletaccount wa) {
		// TODO Auto-generated method stub
		return dao.addAccount(wa);
	}

	@Override
	public Walletaccount deleteaccount(int accountid) {
		// TODO Auto-generated method stub
		return dao.deleteaccount(accountid);
	}
	
	public Walletaccount deposit(Walletaccount wa,double amount)
	{
		return dao.deposit(wa, amount);
	}
	public double getbalance(int id)
	{
		return dao.getbalance(id);
	}
	public Walletaccount fundTransfer(int fromaccountid,int toaccountid,double amount)
	{
		return dao.fundTransfer(fromaccountid,toaccountid,amount);
	}


}
