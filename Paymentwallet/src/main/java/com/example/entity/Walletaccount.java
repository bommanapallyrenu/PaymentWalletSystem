package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="walletaccount")
public class Walletaccount 
{
	@Id
	int accountid;
	double accountbalance;
	String status;
	
	 //@OneToMany(mappedBy="walletaccount",fetch = FetchType.EAGER)
	// private List<Wallettransaction> translist=new ArrayList<>();
	 
	 
	public Walletaccount() {
		super();
	}
	/*public List<Wallettransaction> getTranslist() {
		return translist;
	}

	public void setTranslist(List<Wallettransaction> translist) {
		this.translist = translist;
	}
*/
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountbalance=" + accountbalance + ", status=" + status + "]";
	}	
}
