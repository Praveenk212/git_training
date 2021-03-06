package com.cg.obs.dto;

import java.time.LocalDate;
import java.util.Date;

public class TransactionDto {
	
	/*
  		Declaration of variables.
	 */
	
	private String username;
	private float amtTransfer;
	private float balance;
	private LocalDate date;
	private float amtReceived;
	
	public TransactionDto(String username, float amtTransfer, float balance, LocalDate date, float amtReceived,
			long receiverAccountNumber, long senderAccountNumber) {
		super();
		this.username = username;
		this.amtTransfer = amtTransfer;
		this.balance = balance;
		this.date = date;
		this.amtReceived = amtReceived;
		this.receiverAccountNumber = receiverAccountNumber;
		this.senderAccountNumber = senderAccountNumber;
	}



	private long receiverAccountNumber;
	private long senderAccountNumber;
	
	/*
		Constructor of the DTO class.
	 */
	
	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	
	public long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}
	
	

	public TransactionDto(){}
	
	public TransactionDto(String username, float amtReceived, float balance) {
		super();
		this.username = username;
		this.amtReceived = amtReceived;
		this.balance = balance;
	}

	public TransactionDto(String username, float amtTransfer, float balance, LocalDate date) {
		super();
		this.username = username;
		this.amtTransfer = amtTransfer;
		this.balance = balance;
		this.date = date;
	}

	
	
	/*
		Getter-Setter to get and set the values.
	 */
	
	public float getAmtReceived() {
		return amtReceived;
	}

	public void setAmtReceived(float amtReceived) {
		this.amtReceived = amtReceived;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getAmtTransfer() {
		return amtTransfer;
	}

	public void setAmtTransfer(float amtTransfer) {
		this.amtTransfer = amtTransfer;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	/*
	To string method
*/	

	@Override
	public String toString() {
		return "TransactionDto [username=" + username + ", amtTransfer=" + amtTransfer + ", balance=" + balance
				+ ", date=" + date + ", amtReceived=" + amtReceived + "]";
	}
	
	
	
	

}
