package com.cg.obs.dto;

public class UserDto {
	
	/*
	  	Declaration of variables.
	*/
	private String userName;
	private String password;
	private String custName;
	private int age;
	private String gender;
	private String emailId;
	private String address;
	private long aadharNo;
	private long phoneNo;
	
	
	/*
		Constructor of the DTO class.
	*/
	public UserDto(){}

	public UserDto(String userName, String password, String custName, int age, String gender, String emailId,
			String address, long aadharNo, long phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.custName = custName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.address = address;
		this.aadharNo = aadharNo;
		this.phoneNo = phoneNo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	


	/*	
		Override toString() method
	*/
	
	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", password=" + password + ", custName=" + custName + ", age=" + age
				+ ", gender=" + gender + ", emailId=" + emailId + ", address=" + address + ", aadharNo=" + aadharNo
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
	

	
	
}
