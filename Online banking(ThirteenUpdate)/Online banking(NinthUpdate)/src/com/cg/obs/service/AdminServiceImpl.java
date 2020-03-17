package com.cg.obs.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.cg.obs.dao.AdminDao;
import com.cg.obs.dao.AdminDaoImpl;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class AdminServiceImpl implements AdminService{

	AdminDao admindao=new AdminDaoImpl();
	UserDto userdao=new UserDto();
	AccountDto accDto=new AccountDto();
	

//*************************To add a new customer by Admin**************************	
	
	@Override
	public String addCustomer(String newUserName, String newPassword, String custName,
			int custAge, String custGender, String custAddress, long custMobileNo, long custAadharNo,
			String custEmailId)
	{
		
		UserDto userdao=new UserDto();
		AccountDto accDto=new AccountDto();
		
		userdao.setCustName(custName);
		userdao.setAge(custAge);
		userdao.setGender(custGender);
		userdao.setAddress(custAddress);
		userdao.setPhoneNo(custMobileNo);
		userdao.setAadharNo(custAadharNo);
		userdao.setEmailId(custEmailId);
		userdao.setUserName(newUserName);
		userdao.setPassword(newPassword);
		
		accDto.setUserName(newUserName);
		accDto.setBalance(0.0000000f);
		accDto.setAccNo(accDto.getStaticAccNo());
		
		return admindao.addCustomer(accDto,userdao);
	}
	

	
//*****************************To View the Customer List**********************************
	
	@Override
	public HashMap<AccountDto,UserDto> viewCustomerList()
	{
		return admindao.viewCustomerList();
	}

	
	
//******************************TO check the yearly transaction of customer:******************	

	@Override
	public List<TransactionDto> yearlyTransactionDetails(long accNo)
	{
		
		return admindao.yearlyTransactionDetails(accNo);
	}

//******************To check the pending request and approved as per the rules:**************
	
	@Override
	public HashMap<Integer,AccountDto> serviceHandling()
	{
		return admindao.serviceHandling();
	}

	
	
//******************************TO check the quarterly transaction of customer:******************
		
	@Override
	public List<TransactionDto> quarterlyTransactionDetails(long accNo) 
	{
		return admindao.quarterlyTransactionDetails(accNo);
	}
	
	
	
//******************************TO check the monthly transaction of customer:******************
		
	@Override
	public List<TransactionDto> monthlyTransactionDetails(long accNo) 
	{
		return admindao.monthlyTransactionDetails(accNo);
	}


	
	//******************************TO check the yearly transactions:******************

	@Override
	public List<TransactionDto> allYearlyTransactionDetails() 
	{
		return admindao.allYearlyTransactionDetails();
	}


	
	//******************************TO check the all quarterly transactions:******************

	@Override
	public List<TransactionDto> allQuarterlyTransactionDetails() 
	{
		return admindao.allQuarterlyTransactionDetails();
	}


	
	//******************************TO check the all monthly transactions:******************
	
	@Override
	public List<TransactionDto> allMonthlyTransactionDetails() 
	{
		return admindao.allMonthlyTransactionDetails();
	}



	@Override
	public String acceptRequest(int requestId,int requestvalue)
	{
		return admindao.acceptRequest(requestId,requestvalue);
	}



}
