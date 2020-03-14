package com.cg.obs.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class StaticTransferDb {

	public static HashMap<AccountDto,TransactionDto> transactionDb=new HashMap<AccountDto,TransactionDto>();
	
	static Set<AccountDto> accountSet=new HashSet<AccountDto>();
	
	
	public static Long getAccNo(String userName){
		accountSet.addAll(StaticCustomerDb.getCustomerDb().keySet());
		for(AccountDto accDto:accountSet){
			if(accDto.getUserName().equals(userName)){
				return accDto.getAccNo();
			}
		}
		return null;

	}
	
	

	static
	{
		transactionDb.put(new AccountDto("soham1808",50000,"0",getAccNo("soham1808")),new TransactionDto("soham1808",0,50000,LocalDate.now()));

		transactionDb.put(new AccountDto("praveen012",10000,"0",getAccNo("praveen012")),new TransactionDto("praveen012",0,10000,LocalDate.now()));
		
		transactionDb.put(new AccountDto("pooja3004",1000000000,"0",getAccNo("pooja3004")),new TransactionDto("pooja3004",0,1000000000,LocalDate.now()));
		
		transactionDb.put(new AccountDto("om012",100000,"0",getAccNo("om012")),new TransactionDto("om012",0,100000,LocalDate.now()));

	}

}
