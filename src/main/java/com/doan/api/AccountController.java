package com.doan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doan.model.Account;
import com.doan.service.AccountService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("account")
	public boolean authAccount(@RequestBody Account acc) {
		return accountService.authAccount(acc);
	}
}
