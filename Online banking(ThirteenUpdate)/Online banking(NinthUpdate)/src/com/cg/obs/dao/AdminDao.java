package com.cg.obs.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public interface AdminDao 
{
	
//*************************To add a new customer by admin:************************** 
	
	public String addCustomer(AccountDto accDto, UserDto userdto);
	
	
	
//*****************************To View the Customer List**********************************
	
	public HashMap<AccountDto,UserDto> viewCustomerList();
	
	
//******************************TO check the yearly transaction of customer:******************
	
	public List<TransactionDto> yearlyTransactionDetails(long accNo);
	
	
//******************To check the pending request and approved as per the rules:**************	
	
	public HashMap<Integer, AccountDto> serviceHandling();
	
	
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
		
		
		public String acceptRequest(int requestId,int requestvalue);
}
