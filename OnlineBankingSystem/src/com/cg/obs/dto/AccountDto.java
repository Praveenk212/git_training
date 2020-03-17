package com.cg.obs.dto;

import java.time.LocalDate;

public class AccountDto {
	
	/*
  		Declaration of variables.
	 */
	
	private String userName;
	private  static long staticAccNo=10000000010L;
	private float balance;
	private String serviceId;
	private long accNo;
	private LocalDate date;
	
	
	/*
		Constructor of the DTO class.
	 */
	
	public AccountDto(){}


	public AccountDto(String userName, float balance,String serviceId) {
		super();
		this.userName = userName;
		this.balance = balance;
		this.serviceId=serviceId;
		accNo=++staticAccNo;
	}
	
	
	

	
	public AccountDto(String userName, float balance, String serviceId, long accNo) {
		super();
		this.userName = userName;
		this.balance = balance;
		this.serviceId = serviceId;
		this.accNo = accNo;
	}


	/*
		Getter-Setter to get and set the values.
	 */

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getAccNo() {
		return accNo;
	}


	public  void setAccNo(long accNo) {
		this.accNo = accNo;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "AccountDto [userName=" + userName + ", accNo=" + accNo + ", balance=" + balance + ", serviceId="
				+ serviceId + "]";
	}


//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return this.getAccNo()!=((AccountDto)obj).getAccNo();
//	}

	
//	@Override
//	public boolean equals(Object obj)
//	{
//		AccountDto accDto=(AccountDto)obj;
//		if(this.accNo==accDto.accNo)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
//	public int hashCode()
//	{
//		return (int) this.accNo;
//	}




	
	
	
	
	

}
