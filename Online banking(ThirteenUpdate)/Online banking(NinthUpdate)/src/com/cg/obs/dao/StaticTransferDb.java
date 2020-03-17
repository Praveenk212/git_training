package com.cg.obs.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class StaticTransferDb
{

	
//*****Declaration of static data for customer information and put it in Data Structure(HashMap):*******
	
	
	public static HashMap<AccountDto,TransactionDto> transactionDb=new HashMap<AccountDto,TransactionDto>();

	static
	{
		transactionDb.put(new AccountDto("soham1808",50000),
		new TransactionDto("soham1808",10000,40000,LocalDate.of(2019, 12, 1)));
		
		transactionDb.put(new AccountDto("soham1808",40000),
		new TransactionDto("soham1808",10000,30000,LocalDate.of(2019, 3, 11)));
		
		transactionDb.put(new AccountDto("soham1808",50000),
		new TransactionDto("soham1808",2000,28000,LocalDate.of(2019, 12, 9)));
		
		transactionDb.put(new AccountDto("praveen012",10000),
		new TransactionDto("praveen012",2000,8000,LocalDate.of(2020, 1, 9)));
		
		transactionDb.put(new AccountDto("praveen012",8000),
		new TransactionDto("praveen012",3000,5000,LocalDate.of(2020, 3, 1)));
	}
	
	
//************Getter and setter function for customerDb (Account holder Information HashMap)************	
	
	public static HashMap<AccountDto, TransactionDto> getTransactionDb()
	{
		return transactionDb;
	}
	public static void setTransactionDb(HashMap<AccountDto, TransactionDto> transactionDb) 
	{
		StaticTransferDb.transactionDb = transactionDb;
	}

}
