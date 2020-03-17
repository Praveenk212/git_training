package com.cg.obs.service;

import com.cg.obs.dao.CustomerDao;
import com.cg.obs.dao.CustomerDaoImpl;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.Addtionaliformation;
import com.cg.obs.dto.UserDto;

public class CustomerServiceImpl implements CustomerService{

	//Object creation of all classes.
	
	CustomerDao custDao=new CustomerDaoImpl();
	UserDto userdao=new UserDto();
	AccountDto accDto=new AccountDto();
	Addtionaliformation addInfo=new Addtionaliformation();
	
	
//***************************** Function to add a new Customer:*****************************
	
	
	@Override
	public String addCustomer(String userName,String password,String custName, int custAge, String custGender, String custAddress, 
			long custMobileNo, long custAadharNo, String custEmailId)
	{
		AccountDto accDto=new AccountDto();
		CustomerDao custDao=new CustomerDaoImpl();
		
		userdao.setCustName(custName);
		userdao.setAge(custAge);
		userdao.setGender(custGender);
		userdao.setAddress(custAddress);
		userdao.setPhoneNo(custMobileNo);
		userdao.setAadharNo(custAadharNo);
		userdao.setEmailId(custEmailId);
		userdao.setUserName(userName);
		userdao.setPassword(password);
		
		//System.out.println(accDto.getStaticAccNo());
		accDto.setUserName(userName);
		accDto.setBalance(0.000000f);
		accDto.setAccNo(accDto.getStaticAccNo());
		
		return custDao.addCustomer(accDto,userdao);
	}
	
	
	
	
//*****************************Function to View statements of Customer:*************************	
	
	@Override
	public String viewStatement(String userName)
	{
		return custDao.viewStatement(userName);
	}

	
	
//*****************************Function to view Summary of Customer:**********************
	
	@Override
	public String viewSummary(String userName)
	{
		return custDao.viewSummary(userName);
	}

	
	
//*****************************Function to view Personal Details of Customer:**********************	
	
	@Override
	public String viewPersonalDetails(String userName) {
		// TODO Auto-generated method stub
		return custDao.viewPersonalDetails(userName);
	}

	
	
//*****************************Function to transfer money from Customer account:**********************	
	
	@Override
	public String transferAmt(String userName,long receiverAccNo,float transferBalance)
	{
		
		return custDao.transferAmt(userName,receiverAccNo,transferBalance); 
	}

	
	
//*****************************Function to update password of Customer:**********************
	
	@Override
	public String updatepassword(String updateuserName, String updateDetail) {
		return custDao.updatepassword(updateuserName, updateDetail);
	}
	
	
	
//*****************************Function to request for ChequeBook of Customer:**********************
	
	@Override
	public int requestChequeBook(String userName,long accountNo) {
		return custDao.requestChequeBook(userName,accountNo);
	}
	
	
	
//*****************************Function to request for CreditCard of Customer:**********************

	@Override
	public int requestCreditCard(String userName,String custName,int custAge,String custGender,String custAddress,
			long custMobileNo,long custAadharNo,String custEmailId,String custCity,long custIncome)
	{
		addInfo.setCustName(custName);
		addInfo.setAge(custAge);
		addInfo.setGender(custGender);
		addInfo.setAddress(custAddress);
		addInfo.setPhoneNo(custMobileNo);
		addInfo.setAadharNo(custAadharNo);
		addInfo.setEmailId(custEmailId);
		addInfo.setCity(custCity);
		addInfo.setIncome(custIncome);
		addInfo.setUserName(userName);
		addInfo.setRequestId(0);
		return custDao.requestCreditCard(addInfo);
	}

	
	
//*****************************Function to check Request Status of Customer:**********************
	
	@Override
	public String checkRequestStatus(String userName, int requestId)
	{
		return custDao.checkRequestStatus(userName,requestId);
	}
	
	
	
//*****************************Function to update Contact Details of Customer:**********************
	
	@Override
	public String updateContactDetails(String updateuserName, long updateContact) {

		return custDao.updateContactDetails(updateuserName, updateContact); 
	}

	
	
//*****************************Function to update Email of Customer:**********************
	
	@Override
	public String updateEmail(String updateuserName,String updateEmail)
	{
		return custDao.updateEmail(updateuserName, updateEmail);
	}
	
	
	
	
//*****************************Function to update Address of Customer:**********************
	
	@Override
	public String updateAddress(String updateusername,String updateAddress)
	{
		return custDao.updateAddress(updateusername, updateAddress);
	}

}
