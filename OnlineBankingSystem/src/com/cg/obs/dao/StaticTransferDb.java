package com.cg.obs.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class StaticTransferDb {
	
	public static List<TransactionDto> tranList=null;
	
	//public static HashMap<AccountDto,List<TransactionDto>> transactionDbNew=new HashMap<AccountDto,List<TransactionDto>>();
	

	public static HashMap<AccountDto,TransactionDto> transactionDb=new HashMap<AccountDto,TransactionDto>();
	
	
	
	static Set<AccountDto> accountSet=new HashSet<AccountDto>();
	
	
	public static HashMap<AccountDto, TransactionDto> getTransactionDb() {
		return transactionDb;
	}



	public static void setTransactionDb(HashMap<AccountDto, TransactionDto> transactionDb) {
		StaticTransferDb.transactionDb = transactionDb;
	}



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
		transactionDb.put(new AccountDto("soham1808",50000,"0",getAccNo("soham1808")),
				new TransactionDto("soham1808",1000,50000,LocalDate.of(2020, 2, 02),0,getAccNo("pooja3004"),getAccNo("soham1808")));
     
		transactionDb.put(new AccountDto("praveen012",10000,"0",getAccNo("praveen012")),
				new TransactionDto("praveen012",0,10000,LocalDate.of(2020, 1, 02),1000,getAccNo("om012"),getAccNo("praveen012")));
		
		transactionDb.put(new AccountDto("pooja3004",100000,"0",getAccNo("pooja3004")),
				new TransactionDto("pooja3004",0,100000,LocalDate.of(2020, 2, 02),1000,getAccNo("pooja3004"),getAccNo("soham1808")));
		
		transactionDb.put(new AccountDto("om012",100000,"0",getAccNo("om012")),
				new TransactionDto("om012",1000,100000,LocalDate.of(2020, 1, 02),0,getAccNo("om012"),getAccNo("praveen012")));
		
	}

}
