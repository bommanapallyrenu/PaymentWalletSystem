package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.exceptions.AmountLessThanZeroException;
import com.example.exceptions.IdNotFoundException;
import com.example.service.UserService;
import com.example.service.WalletaccountService;


@RestController
@RequestMapping("/account")
//@CrossOrigin("http://localhost:4200")
public class WalletaccountController {
	
		@Autowired
		WalletaccountService serviceobj;

		// Add account
		@PostMapping("/addAccount")
		public ResponseEntity<String> addAccount(@RequestBody Walletaccount wa) {
			Walletaccount wal_account = serviceobj.addAccount(wa);
			if (wal_account == null) {
				throw new IdNotFoundException("Enter Valid Id");
			} else {
				return new ResponseEntity<String>("Account created successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		
		// Delete User
		@DeleteMapping("/DeleteAccount/{accountid}")
		private ResponseEntity<String> deleteaccount(@PathVariable("accountid") int accountid) {
			Walletaccount wal_account = serviceobj.deleteaccount(accountid);
			if (wal_account == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		@PutMapping("/Deposit/{amount}")
		public ResponseEntity<String> updateUser(@RequestBody Walletaccount wa,@PathVariable("amount") double amount) {
			Walletaccount wal_account = serviceobj.deposit(wa, amount);
		     if(amount<0&&wal_account==null)
			{
				throw new AmountLessThanZeroException("Amount cannot be less than zero");	
			} 
		     else if (wal_account == null&&amount>0) {
					throw new IdNotFoundException(" Operation Unsuccessful, id not found");
				}
			else {
				return new ResponseEntity<String>("Amount deposited successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		@GetMapping("/GetBalance/{accountid}")
		public ResponseEntity<Double> getbalance(@PathVariable("accountid") int accountid) {
			double balance = serviceobj.getbalance(accountid);
			if (balance==0) {
				throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
			} else {
				return new ResponseEntity<Double>(balance, new HttpHeaders(), HttpStatus.OK);
			}
		}
		@PutMapping("/fundtransfer/{fromaccountid}/{toaccountid}/{amount}")
		public ResponseEntity<String> fundTransfer(@PathVariable("fromaccountid") int fromaccountid,@PathVariable("toaccountid") int toaccountid,@PathVariable("amount") double amount) {
			Walletaccount wal_account = serviceobj.fundTransfer(fromaccountid, toaccountid, amount);
		     if(amount<0&&wal_account==null)
			{
				throw new AmountLessThanZeroException("Amount cannot be less than zero");	
			} 
		     else if (wal_account == null&&amount>0) {
					throw new IdNotFoundException(" Operation Unsuccessful, id not found");
				}
			else {
				return new ResponseEntity<String>("Amount transfered successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

}
