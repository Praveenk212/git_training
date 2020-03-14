package com.cg.obs.service;

import com.cg.obs.dao.CustomerDao;
import com.cg.obs.dao.CustomerDaoImpl;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.InfoDto;
import com.cg.obs.dto.UserDto;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao custDao=new CustomerDaoImpl();
	InfoDto infoDto=new InfoDto();
	
	
	
	@Override
	public boolean custLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return custDao.custLogin(userName, passWord);
	}

	@Override
	public String addCustomer(AccountDto accDto,UserDto userDto) {
		// TODO Auto-generated method stub
		return custDao.addCustomer( accDto,userDto);
	}

	@Override
	public String viewStatement(String userName) {
		return custDao.viewStatement(userName);
		
	
	}

	@Override
	public String viewSummary(String userName) {
		
		return custDao.viewSummary(userName);
	}

	@Override
	public String viewPersonalDetails(String userName) {
		// TODO Auto-generated method stub
		return custDao.viewPersonalDetails(userName);
	}

	@Override
	public String transferAmt(String senderUserName,Long receiverAccNo,float amount)  {
		// TODO Auto-generated method stub
		return custDao.transferAmt(senderUserName,receiverAccNo,amount);
	}

	@Override
	public String updateContactDetails(String userName, long updateContact) {

		return custDao.updateContactDetails(userName, updateContact); 
	}
	
	@Override
	public String updateEmail(String userName,String updateEmail)
	{
		return custDao.updateEmail(userName, updateEmail);
	}

	@Override
	public String updateAddress(String userName,String updateAddress)
	{
		return custDao.updateAddress(userName, updateAddress);
	}
	
	@Override
	public String updatepassword(String userName, String updateDetail) {
		return custDao.updatepassword(userName, updateDetail);
	}
	
	
	//request for cheque book

	@Override
	public int requestChequeBook(String userName,long accountNo) {
		return custDao.requestChequeBook(userName,accountNo);
	}
	
	//check request status
	
	@Override
	public String checkRequestStatus(String userName, int requestId)
	{
		return custDao.checkRequestStatus(userName,requestId);
	}

	@Override
    public int requestCreditCard(String userName,String custName,int custAge,String custGender,String custAddress,
            long custMobileNo,long custAadharNo,String custEmailId,String custCity,long custIncome)
    {
        infoDto.setCustName(custName);
        infoDto.setAge(custAge);
        infoDto.setGender(custGender);
        infoDto.setAddress(custAddress);
        infoDto.setPhoneNo(custMobileNo);
        infoDto.setAadharNo(custAadharNo);
        infoDto.setEmailId(custEmailId);
        infoDto.setCity(custCity);
        infoDto.setIncome(custIncome);
        infoDto.setUserName(userName);
        infoDto.setRequestId(0);
        return custDao.requestCreditCard(infoDto);
    }



}
