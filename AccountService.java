package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {

	Account createAccount(int accNum, int amount)
			throws InsufficientInitialAmountException;
	
	int depositAmount(int accNum, int amount) throws InvalidAccountNumberException;
	
}
