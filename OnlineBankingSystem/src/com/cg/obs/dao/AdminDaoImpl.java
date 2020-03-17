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
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class AdminDaoImpl implements AdminDao{
	
	StaticTransferDb tDb = new StaticTransferDb();
	StaticCustomerDb cDb=new StaticCustomerDb();
	Set<AccountDto> accountSet=new HashSet<AccountDto>();

	
	
	@Override
	public boolean login(String userName, String password) 
	{
		if(userName.equals("admin") && password.equals("admin"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@Override
	public String addCustomer(AccountDto accDto,UserDto userDto) {
		cDb.customerDb.put(accDto, userDto);
		//TransactionDto tranDto=new TransactionDto();
		//tDb.transactionDb.put(accDto,tranDto );
		return "Detail of username "+userDto.getUserName()+" Added Sucessfully";
	}

	@Override
	public String viewCustomerList() 
	{
		
		accountSet.addAll(cDb.customerDb.keySet());
		//System.out.println(arrayList);
		String customerList="";
		for(AccountDto accDto:accountSet)
		{
			
			customerList+="Account Number: "+accDto.getAccNo()+" UserName:  "+accDto.getUserName()+"  \n";
	
		}
		accountSet.clear();
		return customerList;
	}

	@Override
	public String transactionDetails() {
		accountSet.addAll(tDb.transactionDb.keySet());
		//System.out.println(arrayList);
		String statementDetails="";
		for(AccountDto accDto:accountSet){
				TransactionDto tranDto=tDb.transactionDb.get(accDto);
				statementDetails+=
						"\nSender Account Number : "+ tranDto.getSenderAccountNumber()+
						" Receiver Account Number : "+ tranDto.getReceiverAccountNumber()+
						" UserName: "+ accDto.getUserName()+"	Account Number: "+ accDto.getAccNo()+
						"	Date: "+ tranDto.getDate()+" 	Transfer Amount: " +tranDto.getAmtTransfer()+" 	Received Amount: " +tranDto.getAmtReceived()+" 	Remaining Balnace: "+tranDto.getBalance()+"\n";
		}
		accountSet.clear();
		return statementDetails;
	}
	
	
	

	@Override
	public String serviceHandling() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	@Override
	public List<TransactionDto> yearlyTransactionDetails(long accNo) 
	{
		HashMap<AccountDto,TransactionDto> allTranstList= tDb.getTransactionDb();

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


	@Override
	public List<TransactionDto> monthlyTransactionDetails(long accNo) 
	{HashMap<AccountDto,TransactionDto> allTranstList=StaticTransferDb.getTransactionDb();

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
	
}
