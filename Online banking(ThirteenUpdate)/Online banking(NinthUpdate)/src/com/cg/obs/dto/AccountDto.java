package com.cg.obs.dto;

import java.time.LocalDate;
import java.util.Map.Entry;

import com.cg.obs.dao.StaticCustomerDb;

public class AccountDto 
{
	
	StaticCustomerDb scDb=new StaticCustomerDb();
	
	/*
  		*******************Declaration of variables.********************************
	 */
	
	private String userName;
	private long accNo;
	private float balance;
	private long StaticAccNo=1000000001L;
	private String requestMessage;
	private LocalDate date;
	private long income;
	
	
	
	/*
	********************************Constructor of the DTO class.*****************************
	 */
	
	public AccountDto(String userName, long accNo, float balance, String requestMessage, LocalDate date) {
		super();
		this.userName = userName;
		this.accNo = accNo;
		this.balance = balance;
		this.requestMessage = requestMessage;
		this.date = date;
		
	}

	public AccountDto()
	{
		
	}

	public AccountDto(String userName,float balance) 
	{
		super();
		this.userName = userName;
		this.balance = balance;
		for(Entry<AccountDto, UserDto> entry:scDb.getCustomerDb().entrySet())
		{
			if(entry.getValue().getUserName().equals(userName))
			{
				this.accNo=entry.getKey().getAccNo();
			}
		}
	}
	
	public AccountDto(String userName,float balance, long accNo)
	{
		super();
		this.userName = userName;
		this.accNo=this.getStaticAccNo();
		this.balance = balance;
	}

	
	
	/*
	 ***************Getter-Setter to get and set the values.**************************
	 */
	
	
	public String getRequestId() {
		return requestMessage;
	}

	public void setRequestId(String requestMessage) {
		this.requestMessage = requestMessage;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public long getStaticAccNo()
	{
		return (long) Math.abs(Math.random()*111212+1012101010);
	}


	public void setStaticAccNo(long staticAccNo) 
	{
		StaticAccNo = staticAccNo;
	}


	public String getUserName() 
	{
		return userName;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public long getAccNo()
	{
		return accNo;
	}


	public void setAccNo(long accNo)
	{
		this.accNo = accNo;
	}


	public float getBalance()
	{
		return balance;
	}
	public void setBalance(float balance)
	{
		this.balance = balance;
	}
	
	public String getRequestMessage()
	{
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage)
	{
		this.requestMessage = requestMessage;
	}
	
	//**************************To string method:*****************************
	
	@Override
	public String toString()
	{
		return "AccountDto [scDb=" + scDb + ", userName=" + userName + ", accNo=" + accNo + ", balance=" + balance
				+ ", StaticAccNo=" + StaticAccNo + ", requestMessage=" + requestMessage + ", date=" + date + "]";
	}

}
