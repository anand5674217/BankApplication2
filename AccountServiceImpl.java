package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	AccountRepository accountrepository ;
	Account account =new Account();

	public AccountServiceImpl(AccountRepository accountrepository) {
		super();
		this.accountrepository = accountrepository;
	}

	public Account createAccount(int accNum, int amount)
			throws InsufficientInitialAmountException {
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		account.setAccountNumber(accNum);
		account.setAmount(amount);
		
		if(accountrepository.save(account))
		{
			return account;
		}
		
	
		
		return null;
	}

	public int depositAmount(int accNum, int amount)throws InvalidAccountNumberException {
		Account acc=accountrepository.searchAccount(accNum);

		acc.setAmount(amount+account.getAmount());
		
			return acc.getAmount();

		
}
}