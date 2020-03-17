package com.cg.obs.dto;

public class Addtionaliformation
{
	//****************************Data Field Declaration:********************************
	
	private String userName;
	private String password;
	private String custName;
	private int age;
	private String gender;
	private String emailId;
	private String address;
	private long aadharNo;
	private long phoneNo;
	private long income;
	private String city;
	public int staticRequestId=10001;
	private int requestId;
	
	
	//******************************Constructor using all field:************************************
	
	public Addtionaliformation(String userName, String password, String custName, int age, String gender,
			String emailId, String address, long aadharNo, long phoneNo, long income, String city, int requestId)
	{
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
		this.income = income;
		this.city = city;
		this.requestId = requestId;
	}
	
	//*******************Constructor using super class:***********************
	
		public Addtionaliformation() 
		{
			super();
		}
		
	
	//***************************Generated getter and setter function:***************************
	
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = staticRequestId+1;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword(){
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
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	//************************To string method:************************
	
	@Override
	public String toString() 
	{
		return "Addtionaliformation [userName=" + userName + ", password=" + password + ", custName=" + custName
				+ ", age=" + age + ", gender=" + gender + ", emailId=" + emailId + ", address=" + address
				+ ", aadharNo=" + aadharNo + ", phoneNo=" + phoneNo + ", income=" + income + ", city=" + city
				+ ", requestId=" + requestId + "]";
	}
	
}
