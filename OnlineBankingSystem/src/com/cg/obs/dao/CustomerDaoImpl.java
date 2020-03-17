package com.cg.obs.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.InfoDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class CustomerDaoImpl implements CustomerDao{

	StaticTransferDb tDb = new StaticTransferDb();
	StaticCustomerDb cDb=new StaticCustomerDb();
	StaticTransferDbNew tNewDb=new StaticTransferDbNew();
	Set<AccountDto> accountSet=new HashSet<AccountDto>();
	
	List<TransactionDto> tranList=null;
	
	
	
public static HashMap<Integer,AccountDto> requestList=new HashMap<Integer,AccountDto>();
	
	public static HashMap<Integer, AccountDto> getRequestList() 
	{
		return requestList;
	}
	public static void setRequestList(HashMap<Integer, AccountDto> requestList)
	{
		CustomerDaoImpl.requestList = requestList;
	}

	
	InfoDto addtInfo=new InfoDto();





	@Override
	public String addCustomer(AccountDto accDto,UserDto userDto) {
		cDb.customerDb.put(accDto, userDto);
		//TransactionDto tranDto=new TransactionDto();
		//tDb.transactionDb.put(accDto,tranDto );
		return "Detail of username "+userDto.getUserName()+" Added Sucessfully";
		
	}

	@Override
	public boolean custLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		accountSet.addAll(cDb.customerDb.keySet());
		//System.out.println(arrayList);
		boolean validUser=false;
		for(AccountDto accDto:accountSet)
		{
			//System.out.println(accDto);
			UserDto userDto=cDb.customerDb.get(accDto);
			if(userDto.getUserName().equals(userName))
			{
				//System.out.println(userDto);
				if((userDto.getUserName().equals(userName)) && (userDto.getPassword().equals(passWord)))
				{
					validUser= true;
					break;
				}
				else
				{
					validUser= false;
				}
			}
		}
		accountSet.clear();
		return validUser;
	}


	@Override
	public String viewStatement(String userName) {
		accountSet.addAll(tDb.transactionDb.keySet());
		//System.out.println(arrayList);
		String statement="";
		boolean flag=true;
		for(AccountDto accDto:accountSet)
			
		{
			if(accDto.getUserName().equals(userName))
			{
				TransactionDto tranDto=tDb.transactionDb.get(accDto);
					statement+=
							" Sender Account Number : "+ tranDto.getSenderAccountNumber()+
							" Receiver Account Number : "+ tranDto.getReceiverAccountNumber()+
							" Date: "+ tranDto.getDate()+" 	Transfer Amount: " +tranDto.getAmtTransfer()+
							" 	Received Amount: " +tranDto.getAmtReceived()+" 	Remaining Balnace: "+tranDto.getBalance()+"\n";
			   flag=false;
			}
		}
		if(flag==true)
		{
			statement+="Do the transaction first!!!";
		}
		accountSet.clear();
		return statement;
	}

	@Override
	public String viewSummary(String userName) {
		accountSet.addAll(cDb.customerDb.keySet());
		//System.out.println(arrayList);
		String summary="";
		for(AccountDto accDto:accountSet){
			if(accDto.getUserName().equals(userName))
			{
				summary+="Account Number: "+accDto.getAccNo()+"		Account Balance:  "+accDto.getBalance()+"  \n";
			}
		}
		accountSet.clear();
		return summary;
	}

	@Override
	public String viewPersonalDetails(String userName) {

		accountSet.addAll(cDb.customerDb.keySet());
		//System.out.println(arrayList);
		String personalDetail="";
		for(AccountDto accDto:accountSet)
		{
			if(accDto.getUserName().equals(userName))
			{
				UserDto userDto=cDb.customerDb.get(accDto);
				personalDetail+="\nName :"+userDto.getCustName()+"\nAge:"+userDto.getAge()
				+"\nAadhar Number :"+userDto.getAadharNo()+"\nAddress :"+userDto.getAddress()
				+"\nGender :"+userDto.getGender()+"\nPhone Number :"+userDto.getPhoneNo()
				+"\nEmail Id :"+userDto.getEmailId();
			}
		}
		accountSet.clear();
		return personalDetail;
	}

	@Override
	public String transferAmt(String senderUserName,Long receiverAccNo,float amount) 
	{
		Set<AccountDto> accountSet=new HashSet<AccountDto>();
		accountSet.addAll(cDb.customerDb.keySet());
		//Set<AccountDto> accountSetTransferDb=new HashSet<AccountDto>();
		//accountSetTransferDb.addAll(tDb.transactionDb.keySet());
		String transferResult="";
		boolean accountExist=false;
		boolean sameAccount=false;
		for(AccountDto accDto:accountSet)
		{
			if(accDto.getUserName().equals(senderUserName) && accDto.getAccNo()==receiverAccNo)
			{
				sameAccount=true;
			}
		}

		for(AccountDto accDto:accountSet)
		{
			if(accDto.getAccNo()==receiverAccNo)
			{
				accountExist=true;
			}
		}

		if(sameAccount)
		{
			transferResult+="Oops can't Transfer as sender and receiver account is same ";
		}
		else
		{

			if(accountExist)
			{
				long senderAccNo=0l;
				for(AccountDto accDto:accountSet)
				{
					if(accDto.getUserName().equals(senderUserName))
					{
						
						if(accDto.getBalance()>=amount)
						{ senderAccNo=accDto.getAccNo();
							TransactionDto tranDto=new TransactionDto();
							float amountLeft=(accDto.getBalance()-amount);
							accDto.setBalance(amountLeft);
							tranDto.setAmtTransfer(amount);
							tranDto.setBalance(amountLeft);
							tranDto.setUsername(accDto.getUserName());
							tranDto.setDate(LocalDate.now());
							tranDto.setReceiverAccountNumber(receiverAccNo);
							tranDto.setSenderAccountNumber(senderAccNo);
							//tranList=new ArrayList<TransactionDto>();
							//tranList.add(tranDto);
				
							/*tDb.transactionDb.put(accDto, tranDto);*/
							AccountDto accDt=new AccountDto();
							accDt.setAccNo(accDto.getAccNo());
							accDt.setBalance(accDto.getBalance());
							accDt.setDate(accDto.getDate());
							accDt.setUserName(accDto.getUserName());
							tDb.transactionDb.put(accDt, tranDto);
							transferResult+=" Amount "+amount+" 	Transfered to "+receiverAccNo;
							
							for(AccountDto accDto1:accountSet)
							{

								if(accDto1.getAccNo()==receiverAccNo)
								{
									TransactionDto tranDto1=new TransactionDto();
									float Totalamount=(accDto1.getBalance()+amount);
									accDto1.setBalance(Totalamount);
									tranDto1.setAmtReceived(amount);
									tranDto1.setBalance(Totalamount);
									tranDto1.setUsername(accDto1.getUserName());
									tranDto1.setReceiverAccountNumber(receiverAccNo);
									tranDto1.setSenderAccountNumber(senderAccNo);
									//System.out.println(accDto1.getUserName());
									tranDto1.setDate(LocalDate.now());
									
									AccountDto accDtoN=new AccountDto();
									accDtoN.setAccNo(accDto1.getAccNo());
									accDtoN.setBalance(accDto1.getBalance());
									accDtoN.setDate(accDto1.getDate());
									accDtoN.setUserName(accDto1.getUserName());
									//System.out.println(tranDto1);
									tDb.transactionDb.put(accDtoN, tranDto1);
//									tranList=new ArrayList<TransactionDto>();
//									tranList.add(tranDto1);
//									tNewDb.transactionDbNew.put(accDto, tranList);
								}
							}
						}
						else
						{
							transferResult+="Oops can't Transfer as amount is not sufficient ";
						}
					}
				}

			}
			else
			{
				transferResult+="Accont "+receiverAccNo+" 	Not Exist";
			}
		}
		return transferResult;
	}
	
	

	/*
	customer contact update
	*/
	
	
	@Override
	public String updateContactDetails(String userName,long updateContact)
	{
		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
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
	/*
		customer Email update				
	 */
	
	@Override
	public String updateEmail(String userName,String updateEmail)
	{
		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(userName))
			{
				userDto.setEmailId(updateEmail);
				return "Your Email has successfully updated.";
			}
		}
		return "User Name not found";
	}
	
	/*
	customer address update				
 */
	
	@Override
	public String updateAddress(String userName,String updateAddress)
	{
		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			if(entry.getKey().getUserName().equals(userName))
			{
				userDto.setAddress(updateAddress);
				return "Your Address has successfully updated.";
			}
		}
		return "User Name not found";

	}
	/*
			update password
	
	*/
	
	@Override
	public String updatepassword(String userName, String updateDetail) {

		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
		{
			UserDto userDto=entry.getValue();
			
			if(entry.getKey().getUserName().equals(userName))
			{
				userDto.setPassword(updateDetail);
				return "Your password has successfully updated.";
			}
		}
		return "User Name not found";

	}
	
	//request Cheque Book
	
	@Override
	public int requestChequeBook(String userName,long accountNo)
	{
		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
		{
			if(entry.getKey().getUserName().equals(userName))
			{
				if(entry.getKey().getAccNo()==accountNo)
				{
					int generateId=(int) (Math.abs(Math.random())*100000+201);
					
					AccountDto requestDetail=new AccountDto(userName,accountNo,"Pending");
					requestList.put(generateId, requestDetail);
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

	// status of the requests
	
	@Override
	public String checkRequestStatus(String userName, int requestId)
	{
		if(requestList.isEmpty())
		{
			return "Requst Id not found, please Enter the valid Request Id";
		}
		for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
		{
			if(entry.getKey().getUserName().equals(userName) &&
					requestList.containsKey(requestId))
			{ 
				Period interval=Period.between(LocalDate.now(),requestList.get(requestId).getDate());
				if(interval.getDays()>5 ||interval.getMonths()>1 || interval.getYears()>1) 
				{ 
					return "Your Request has been approved";
				} 
				else 
				{
					return "Your Request is pending, please Wait for some time"; 
				}
			} 
		}
		return "Requst Id not found, please Enter the valid Request Id";
	}
	
	
	
	@Override
    public int requestCreditCard(InfoDto addInfo)
    {
        for(Entry<AccountDto, UserDto> entry:cDb.customerDb.entrySet())
        {
            if(entry.getKey().getUserName().equals(addInfo.getUserName()))
            {
                int generateId=(int) (Math.abs(Math.random())*100000+101);
                AccountDto requestDetail=new AccountDto(entry.getKey().getUserName(),entry.getKey().getBalance(),"Pending");
                requestList.put(generateId, requestDetail);
                return generateId;
            }
        }
        return 0;
    }



}
