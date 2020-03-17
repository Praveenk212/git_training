package com.cg.obs.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.Addtionaliformation;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class AdminDaoImpl implements AdminDao
{

	StaticTransferDb stDb=new StaticTransferDb();
	StaticCustomerDb stCustDb=new StaticCustomerDb();
	CustomerDao custDao=new CustomerDaoImpl();
	
	

	
//*************************To add a new customer by admin:************************** 
	
	@Override
	public String addCustomer(AccountDto accDto, UserDto userdto) 
	{
		stCustDb.getCustomerDb().put(accDto, userdto);
		return "Your account has been successfully created";
	}
	
	
	
	
	
	
//*****************************To View the Customer List**********************************
	
	@Override
	public HashMap<AccountDto,UserDto> viewCustomerList() 
	{
		return stCustDb.customerDb;
	}

	
	
	
	
	
//******************************TO check the yearly transaction of customer:******************
	
	@Override
	public List<TransactionDto> yearlyTransactionDetails(long accNo){

		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();

		boolean temp=false;
		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();

			if(key.getAccNo()==accNo)
			{	
				Period interval=Period.between(value.getDate(),LocalDate.now());
				if(interval.getYears()<1)
				{
					temp=true;
					transtList.add(value);
				}
			}
		}
		if(!temp)
		{
			for(Entry<AccountDto,UserDto> entry:acc.getCustomerDb().entrySet())
			{
				if(entry.getKey().getAccNo()==accNo)
				{
					TransactionDto td=new TransactionDto("a",0,0,LocalDate.now());
					transtList.add(td);
				}
			}
		}
		return transtList;
	}

	
	
	

//******************************TO check the quarterly transaction of customer:******************
	
	@Override
	public List<TransactionDto> quarterlyTransactionDetails(long accNo) 
	{
		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();

		boolean temp=false;
		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();

			if(key.getAccNo()==accNo)
			{	
				Period interval=Period.between(value.getDate(),LocalDate.now());
				if(interval.getMonths()<3 && interval.getYears()<1)
				{
					temp=true;
					transtList.add(value);
				}
			}
		}
			if(!temp)
			{
				for(Entry<AccountDto,UserDto> entryNew:acc.getCustomerDb().entrySet())
				{
					if(entryNew.getKey().getAccNo()==accNo)
					{
						TransactionDto td=new TransactionDto("a",0,0,LocalDate.now());
						transtList.add(td);
					}
				}
			}
		return transtList;
	}

	
	
	
	
	
	
//******************************TO check the monthly transaction of customer:******************
	
	@Override
	public List<TransactionDto> monthlyTransactionDetails(long accNo) 
	{
		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();

		boolean temp=false;
		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();
			if(key.getAccNo()==accNo)
			{	
				Period interval=Period.between(value.getDate(),LocalDate.now());
				if(interval.getMonths()<1 && interval.getYears()<1)
				{
					temp=true;
					transtList.add(value);
				}
			}
		}
		if(!temp)
		{
			for(Entry<AccountDto,UserDto> entry:acc.getCustomerDb().entrySet())
			{
				if(entry.getKey().getAccNo()==accNo)
				{
					TransactionDto td=new TransactionDto("a",0,0,LocalDate.now());
					transtList.add(td);
				}
			}
		}
		return transtList;

	}

	
	
	
	
	
	
//******************To check the pending request and approved as per the rules:**************	
	
	@Override
	public HashMap<Integer,AccountDto> serviceHandling()
	{
		Addtionaliformation addInfo=new Addtionaliformation();
		HashMap<Integer,AccountDto> requestList=CustomerDaoImpl.getRequestList();
		HashMap<Integer,AccountDto> requestReturn=new HashMap<Integer,AccountDto>(); 
		if(requestList.isEmpty())
		{
			return requestReturn;
		}
		for(Entry<Integer,AccountDto> entry:requestList.entrySet())
		{
			requestReturn.put(entry.getKey(),entry.getValue());
		}
		return requestReturn;
	}




	//******************************TO check the yearly transactions:******************

	@Override
	public List<TransactionDto> allYearlyTransactionDetails() 
	{
		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();

		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();
			Period interval=Period.between(value.getDate(),LocalDate.now());
			if(interval.getYears()<1)
			{
				transtList.add(value);
			}
		}
		return transtList;

	}



	
//******************************TO check the all quarterly transactions:******************


	@Override
	public List<TransactionDto> allQuarterlyTransactionDetails() 
	{
		
		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();
		
		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();
			Period interval=Period.between(value.getDate(),LocalDate.now());
			if(interval.getMonths()<3 && interval.getYears()<1)
			{
				transtList.add(value);
			}
		}
		return transtList;
	}



	//******************************TO check the all monthly transactions:******************


	@Override
	public List<TransactionDto> allMonthlyTransactionDetails() 
	{
		HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

		List<TransactionDto> transtList=new ArrayList<TransactionDto>();

		StaticCustomerDb acc=new StaticCustomerDb();
		
		for(Entry<AccountDto,TransactionDto> entry:allTranstList.entrySet())
		{
			AccountDto key=entry.getKey();
			TransactionDto value=entry.getValue();
			Period interval=Period.between(value.getDate(),LocalDate.now());
			if(interval.getMonths()<1 && interval.getYears()<1)
			{
				transtList.add(value);
			}
		}
		return transtList;
	}


	//******************************TO Accept or Reject the Customers Requests******************



	@Override
	public String acceptRequest(int requestId,int requestvalue) 
	{
		CustomerDaoImpl.getRequestList().remove(requestId);
		for(Entry<Integer,String> entry:CustomerDaoImpl.getRequestPending().entrySet())
		{
			if(entry.getKey()==requestId)
			{
				if(requestvalue==1)
				{
				CustomerDaoImpl.getRequestPending().replace(requestId, "Approved");
				}
				else
				{
				CustomerDaoImpl.getRequestPending().replace(requestId, "Rejected");
				}
			}	
		}
		return "Request has been updated.";
	}

}
