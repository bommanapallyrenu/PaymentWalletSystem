package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="wallettransaction")
public class Wallettransaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionID", updatable = false, nullable = false)
	private Long transactionID;
	
	
	private double Amount;
	private String description;
	private double Accountbalance;
	private int accountid;
	 
	@Temporal(TemporalType.DATE)
	@Column(name="transactionDate")
	private Date transactionDate;
	
	
	// @ManyToOne
	// private Walletaccount walletaccount;
	public Wallettransaction() {
		super();
	}
	
	
	public Wallettransaction(Long transactionID, double amount, String description, double accountbalance,
			int accountid, Date transactionDate) {
		super();
		this.transactionID = transactionID;
		this.Amount = amount;
		this.description = description;
		this.Accountbalance = accountbalance;
		this.accountid = accountid;
		this.transactionDate = transactionDate;
	}


	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
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
