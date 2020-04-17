package com.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wallettransaction")
public class Wallettransaction 
{
	@Id
	long transactionID;
	Date transactionDate;
	double Amount;
	String description;
	double Accountbalance;
	
	 @ManyToOne
	 private Walletaccount walletaccount;
	public Wallettransaction() {
		super();
	}
	
	public Wallettransaction(long transactionID, Date transactionDate, double amount, String description,
			double accountbalance, Walletaccount walletaccount) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.Amount = amount;
		this.description = description;
		this.Accountbalance = accountbalance;
		this.walletaccount = walletaccount;
	}
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double Amount) {
		this.Amount = Amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAccountbalance() {
		return Accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.Accountbalance = accountbalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate + ", Amount="
				+ Amount + ", description=" + description + ", Accountbalance=" + Accountbalance + "]";
	}
	
}
