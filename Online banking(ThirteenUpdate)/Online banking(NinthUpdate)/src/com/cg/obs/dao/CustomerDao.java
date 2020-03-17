package com.cg.obs.dao;

import java.time.LocalDate;
import java.util.HashMap;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.Addtionaliformation;
import com.cg.obs.dto.UserDto;

public interface CustomerDao {
	
	public String addCustomer(AccountDto accDto, UserDto userdto);
	/*
	 * To View the Details Related to Customer and Transaction
	*/
	public String viewStatement(String userName);
	public String viewSummary(String userName);
	public String viewPersonalDetails(String userName);
	
	
	/*
	 * Transfer Functionality
	*/
	public String transferAmt(String userName,long receiverAccNo, float transferBalance);
	
	
	/*
	 * Update Details 
	 */
	
	public String updatepassword(String updateuserName, String updateDetail);
	public String updateContactDetails(String updateuserName, long updateContact);
	public String updateEmail(String updateuserName,String updateEmail);
	public String updateAddress(String updateusername,String updateAddress);
	/*
	 * Request service functionality
	*/
	
	public int requestChequeBook(String userName,long accountNo);
	public int requestCreditCard(Addtionaliformation addInfo);
	public String checkRequestStatus(String userName, int requestId);
	
	
	
}
