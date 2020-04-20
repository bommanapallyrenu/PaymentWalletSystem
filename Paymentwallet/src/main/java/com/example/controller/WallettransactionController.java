package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;
import com.example.exceptions.IdNotFoundException;
import com.example.service.WalletaccountService;
import com.example.service.WallettransactionService;

@RestController
@RequestMapping("/transaction")
//@CrossOrigin("http://localhost:4200")
public class WallettransactionController {
	
		@Autowired
		WallettransactionService serviceobj;

		// Get All Transaction Data
		@GetMapping("/GetAllTransactions")
		private ResponseEntity<List<Wallettransaction>> getAllTransaction() {
			List<Wallettransaction> translist = serviceobj.getAllTransaction();
			return new ResponseEntity<List<Wallettransaction>>(translist, new HttpHeaders(), HttpStatus.OK);

		}
		
		// Get All Transaction Data by id
		@GetMapping("/GetAllTransactionsById")
		private ResponseEntity<List<Wallettransaction>> getAllTransactionById(@RequestBody Walletaccount wa) {
			List<Wallettransaction> translist = serviceobj.getAllTransactionById(wa);
			
			if (translist == null) {
				throw new IdNotFoundException("Enter Valid Id");
			}
			else
			return new ResponseEntity<List<Wallettransaction>>(translist, new HttpHeaders(), HttpStatus.OK);
		
		}
}
