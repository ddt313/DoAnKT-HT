package com.doan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.model.Account;
import com.doan.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public boolean authAccount(Account acc) {
		return accountRepository.authAccount(acc);
	}

}
