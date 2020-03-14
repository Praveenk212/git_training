package com.cg.obs.dao;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.InfoDto;
import com.cg.obs.dto.UserDto;

public interface CustomerDao {
	
	
	/*
	 * custLogin method will validate a valid user.
	*/
	public boolean custLogin(String userName,String passWord);
	

	public String addCustomer(AccountDto accDto,UserDto userDto);
	/*
	 * To View the Details Related to Customer and Transaction
	*/
	public String viewStatement(String userName);
	public String viewSummary(String userName);
	public String viewPersonalDetails(String userName);
	
	
	/*
	 * Transfer Functionality
	*/
	public String transferAmt(String senderUserName,Long receiverAccNo,float amount) ;
	
	/*
	 * Update Details 
	 */
	
	public String updatepassword(String userName, String updateDetail);
	public String updateContactDetails(String userName, long updateContact);
	public String updateEmail(String userName,String updateEmail);
	public String updateAddress(String userName,String updateAddress);
	
	
	/*
	 * Request service functionality
	*/
	
	public int requestChequeBook(String userName,long accountNo);
	public int requestCreditCard(InfoDto addInfo);
	public String checkRequestStatus(String userName, int requestId);
	
	
}
