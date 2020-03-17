package com.cg.obs.service;

import java.util.List;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public interface AdminService {
	
	
	public boolean login(String userName,String password);
	
	
	
	public String addCustomer(AccountDto accDto,UserDto userDto);
	
	
	public String viewCustomerList();
	
	
	public String transactionDetails();
	
	
	public String serviceHandling();
	
	
	

	
	//******************************TO check the yearly transaction of customer:******************
		
		public List<TransactionDto> yearlyTransactionDetails(long accNo);
		
		
	//******************To check the pending request and approved as per the rules:**************	
		
		
	//******************************TO check the quarterly transaction of customer:******************
		
		public List<TransactionDto> quarterlyTransactionDetails(long accNo);
		
		
	//******************************TO check the monthly transaction of customer:******************
		
		public List<TransactionDto> monthlyTransactionDetails(long accNo);
		
		
		//******************************TO check the yearly transactions:******************
		
			public List<TransactionDto> allYearlyTransactionDetails();
			
			
		//******************************TO check the all quarterly transactions:******************
			
			public List<TransactionDto> allQuarterlyTransactionDetails();
			
			
		//******************************TO check the all monthly transactions:******************
			
			public List<TransactionDto> allMonthlyTransactionDetails();	


}
