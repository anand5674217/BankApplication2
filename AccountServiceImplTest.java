package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

import junit.framework.TestCase;

public class AccountServiceImplTest extends TestCase {
	
	AccountService accountService;
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*
	 * create account
	 * 1.when the amount is less than 500 system should throw exception
	 * 2.when the valid (101,5000) info is passed account should be created successfully
	 */
	/*@Test(expected=com.capgemini.exceptions.InsufficientInitialAmountException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientInitialAmountException
	{
		accountService.createAccount(101, 400);
	}*/
	/*@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialAmountException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account,accountService.createAccount(101,5000));
	}*/
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenTheAccountIsInvalid() throws InvalidAccountNumberException{
		accountService.depositAmount(101, 4000);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAmountShouldBeDepositedSuccessfully() throws InvalidAccountNumberException, InsufficientInitialAmountException
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepository.searchAccount(account.getAccountNumber())).thenReturn(account);
		assertEquals(account,accountService.createAccount(101,5000));
	}
	
}
