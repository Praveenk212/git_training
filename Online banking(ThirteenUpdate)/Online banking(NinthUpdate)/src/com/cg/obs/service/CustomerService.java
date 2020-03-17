package com.cg.obs.service;

public interface CustomerService {
	
	//  Add a new Customer:
	public String addCustomer(String userName,String password, String custName, int custAge, String custGender, String custAddress, 
			long custMobileNo, long custAadharNo, String custEmailId);
	/*
	 * To View the Details Related to Customer and Transaction
	*/
	public String viewStatement(String userName);
	public String viewSummary(String userName);
	public String viewPersonalDetails(String userName);
	
	
	/*
	 * Transfer Functionality
	*/
	public String transferAmt(String userName, long receiverAccNo, float transferBalance);
	
	
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
	
	public int requestCreditCard(String userName,String custName,int custAge,String custGender,
								String custAddress,long custMobileNo,long custAadharNo,
								String custEmailId,String custCity,long custIncome);
	
	public String checkRequestStatus(String userName, int requestId);
	
	
	
}
