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

public class StaticTransferDbNew {
	
	public static List<TransactionDto> tranList=null;
	
	public static HashMap<AccountDto,List<TransactionDto>> transactionDbNew=new HashMap<AccountDto,List<TransactionDto>>();
	

	//public static HashMap<AccountDto,TransactionDto> transactionDb=new HashMap<AccountDto,TransactionDto>();
	
	
	
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
		tranList=new ArrayList<TransactionDto>();
		 tranList.add(new TransactionDto("soham1808",1000,50000,LocalDate.now(),0,getAccNo("pooja3004"),getAccNo("soham1808")));
		
		transactionDbNew.put(new AccountDto("soham1808",50000,"0",getAccNo("soham1808")), 
				   tranList);
		
		tranList=new ArrayList<TransactionDto>();
        tranList.add(new TransactionDto("praveen012",0,10000,LocalDate.now(),1000,getAccNo("om012"),getAccNo("praveen012")));
		
		transactionDbNew.put(new AccountDto("praveen012",10000,"0",getAccNo("praveen012")), 
				   tranList);
		
		tranList=new ArrayList<TransactionDto>();
        tranList.add(new TransactionDto("pooja3004",0,100000,LocalDate.now(),1000,getAccNo("pooja3004"),getAccNo("soham1808")));
		
		transactionDbNew.put(new AccountDto("pooja3004",100000,"0",getAccNo("pooja3004")), 
				   tranList);

		tranList=new ArrayList<TransactionDto>();
        tranList.add(new TransactionDto("om012",1000,100000,LocalDate.now(),0,getAccNo("om012"),getAccNo("praveen012")));
		
		transactionDbNew.put(new AccountDto("om012",100000,"0",getAccNo("om012")), 
				   tranList);

	}

}
