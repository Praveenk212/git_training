package com.cg.obs.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.Addtionaliformation;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class CustomerDaoImpl implements CustomerDao{

//******************************Object creation of all classes***********************************

	StaticTransferDb stDb=new StaticTransferDb();
	StaticCustomerDb stCustDb=new StaticCustomerDb();
	AccountDto accDto=new AccountDto();
	
	public static HashMap<Integer,String> requestPending=new HashMap<Integer,String>();
	public static HashMap<Integer,AccountDto> requestList=new HashMap<Integer,AccountDto>();
	
	public static HashMap<Integer, AccountDto> getRequestList() 
	{
		return requestList;
	}
	public static void setRequestList(HashMap<Integer, AccountDto> requestList)
	{
		CustomerDaoImpl.requestList = requestList;
	}

	TransactionDto trDto=new TransactionDto();
	Addtionaliformation addtInfo=new Addtionaliformation();



//***************************** Function to add a new Customer:*****************************	

	@Override
	public String addCustomer(AccountDto accDto,UserDto userdto)
	{
		stCustDb.getCustomerDb().put(accDto, userdto);
		return "Your account has been successfully created";
	}

	
//*****************************Function to View statements of Customer:*************************

	@Override
	public String viewStatement(String userName)
	{
		String statement="";
		Iterator<Map.Entry<AccountDto,TransactionDto>> itr=stDb.transactionDb.entrySet().iterator();
		while(itr.hasNext())
		{
			Entry<AccountDto,TransactionDto> entry=itr.next();
			AccountDto accDto=entry.getKey();
			TransactionDto trDto=entry.getValue();
			if(accDto.getUserName().equals(userName))
			{
				statement=statement
						+"\n\t\t\t\t|"+accDto.getBalance()
						+"\t\t\t"+trDto.getAmtTransfer()
						+"\t\t\t\t"+trDto.getDate()
						+"\t    |\n\t\t\t\t|-----------------------------------------------------------------------------------|";
			}
		}
		if(statement=="")
		{
			return  "\n\t\t\t\t\t\t\t\tNo Transaction Yet.";
		}
		return statement;
	}

	
	
	
	
//*****************************Function to view Summary of Customer:**********************

	@Override
	public String viewSummary(String userName)
	{
		String summary="";
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			AccountDto accDto=entry.getKey();
			if(entry.getKey().getUserName().equals(userName))
			{
				summary=summary
						+"\t\t\t\t\t\t\t\t| "
						+accDto.getAccNo()
						+"\t\t\t"+accDto.getBalance()+"\t      |";
			}
		}
		return summary;
	}


	
	
	
	
//*****************************Function to view Personal Details of Customer:**********************	

	@Override
	public String viewPersonalDetails(String userName)
	{
		String personalDetails="";
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(userName))
			{
				personalDetails=personalDetails
						+"\n\t\t\t\t\t"
						+"|customer Name         : "+userDto.getCustName()+"\t\t\t\t\t\t\t\t\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Age          :    "+userDto.getAge()+"\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Gender       :    "+userDto.getGender()+"\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Address      :    "+userDto.getAddress()+"\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Contact No   :    "+userDto.getPhoneNo()+"\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Aadhar No    :    "+userDto.getAadharNo()+"\n"
						+"\t\t\t\t\t|---------------------------------------------------|\n"
						+"\t\t\t\t\t|Customer Email ID     :    "+userDto.getEmailId()+"\n"
						;
			}
		}
		return personalDetails;
	}


	
	
	
//*****************************Function to transfer money from Customer account:**********************		

	@Override
	public String transferAmt(String userName,long receiverAccNo, float transferBalance)
	{
		HashMap<AccountDto,TransactionDto> tdAccount=StaticTransferDb.getTransactionDb();
		HashMap<AccountDto,UserDto> custAccount=StaticCustomerDb.getCustomerDb();

		boolean flag=false;
		boolean result=false;
		boolean sameAccount=false;
		AccountDto senderAccountNo=null;
		float senderCurrentBalance = 0;
		for(Entry<AccountDto, UserDto> entry:custAccount.entrySet())
		{
			AccountDto key=entry.getKey();
			UserDto value=entry.getValue();
			if(key.getUserName().equals(userName))
			{
				senderAccountNo=key;
				senderCurrentBalance=key.getBalance();
				if(senderCurrentBalance-transferBalance<0)
				{
					return "Insufficient Balance in your account";
				}
				flag=true;
			}
			if(flag==true && key.getAccNo()==receiverAccNo)
			{
				if(key.getUserName().equals(senderAccountNo.getUserName()))
				{
					sameAccount=true;
					break;
				}
				float currentReceiverBalance=key.getBalance();
				key.setBalance(currentReceiverBalance+transferBalance);
				
				result=true;
				
				senderAccountNo.setBalance(senderCurrentBalance-transferBalance);
				float currentSenderBalance=senderAccountNo.getBalance();
				
				TransactionDto SenderTransactionObject=new TransactionDto(userName,transferBalance,
						currentSenderBalance,LocalDate.now());

				TransactionDto receiverTransactionObject=new TransactionDto(key.getUserName(),transferBalance,
						key.getBalance(),LocalDate.now());

				tdAccount.put(senderAccountNo,SenderTransactionObject);
				tdAccount.put(key,receiverTransactionObject);
			}
		}
		if(sameAccount)
		{
			return "Sender and Recipient are same.";
		}
		if(result)
		{
			return transferBalance+" Rs. Balance has been debited from your account.";
		}
		else
		{
			return "Account not found, pLease Enter the valid account details";
		}
	}

	
	
	
	

//*****************************Function to update password of Customer:**********************	

	@Override
	public String updatepassword(String updateuserName, String updateDetail) {

		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if(entry.getKey().getUserName().equals(updateuserName))
			{
				userDto.setPassword(updateDetail);
				return "Your password has successfully updated.";
			}
		}
		return "User Name not found";

	}

	
	
	
	
	

//*****************************Function to update Contact Details of Customer:**********************	

	@Override
	public String updateContactDetails(String userName,long updateContact)
	{
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(userName))
			{
				userDto.setPhoneNo(updateContact);
				return "Your Contact No. has successfully updated.";
			}
		}
		return "User Name not found";
	}

	
	
	
	
	
//*****************************Function to update Email of Customer:**********************	

	@Override
	public String updateEmail(String updateuserName,String updateEmail)
	{
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(updateuserName))
			{
				userDto.setEmailId(updateEmail);
				return "Your Email has successfully updated.";
			}
		}
		return "User Name not found";
	}

	
	
	
	
//*****************************Function to update Address of Customer:**********************

	@Override
	public String updateAddress(String updateusername,String updateAddress)
	{
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(updateusername))
			{
				userDto.setAddress(updateAddress);
				return "Your Address has successfully updated.";
			}
		}
		return "User Name not found";

	}

	
	
	
	
//*****************************Function to request for ChequeBook of Customer:**********************

	@Override
	public int requestChequeBook(String userName,long accountNo)
	{
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			if(entry.getKey().getUserName().equals(userName))
			{
				if(entry.getKey().getAccNo()==accountNo)
				{
					int generateId=(int) (Math.abs(Math.random())*100000+201);
					
					AccountDto requestDetail=new AccountDto(userName,accountNo,entry.getKey().getBalance(),"Cheque Book",LocalDate.now());
					requestList.put(generateId, requestDetail);
					requestPending.put(generateId,"Pending");
					return generateId;
				}
				else
				{
					System.out.println(requestList);
					return 1;
				}
			}
		}
		return 0;
	}

	
	
	
	
//*****************************Function to request for CreditCard of Customer:**********************	

	@Override
	public int requestCreditCard(Addtionaliformation addInfo)
	{
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			if(entry.getKey().getUserName().equals(addInfo.getUserName()))
			{
				int generateId=(int) (Math.abs(Math.random())*100000+101);
				AccountDto requestDetail=new AccountDto(entry.getKey().getUserName(),entry.getKey().getAccNo(),entry.getKey().getBalance(),"Credit Card",LocalDate.now());
				requestList.put(generateId, requestDetail);
				requestPending.put(generateId,"Pending");
				return generateId;
			}
		}
		return 0;
	}

	
	
	
	
	
//*****************************Function to check Request Status of Customer:**********************	

	public static HashMap<Integer, String> getRequestPending() {
		return requestPending;
	}
	public static void setRequestPending(HashMap<Integer, String> requestPending) {
		CustomerDaoImpl.requestPending = requestPending;
	}
	@Override
	public String checkRequestStatus(String userName, int requestId)
	{
		if(requestPending.isEmpty())
		{
			return "\t\t\t\t\t\tRequst Id not found, please Enter the valid Request Id";
		}
		for(Entry<AccountDto, UserDto> entry:stCustDb.customerDb.entrySet())
		{
			if(entry.getKey().getUserName().equals(userName) &&
					requestPending.containsKey(requestId))
			{
				if(requestPending.get(requestId).equals("Approved"))
				{
					return "\n\t\t\t\t\t\tYour Request has been approved"; 
				}
				if(requestPending.get(requestId).equals("Rejected"))
				{
					return "\n\t\t\t\t\t\tYour Request has been rejected"; 
				}
				if(requestPending.get(requestId).equals("Pending"))
				{
					return "\n\t\t\t\t\t\tYour Request is pending, please Wait for some time"; 
				}
			}
		}
		return "\t\t\t\t\t\tRequst Id not found, please Enter the valid Request Id";
	}
	
}
