package com.cg.obs.dao;

public class AdminDaoImpl implements AdminDao{

	
	
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
	public String addCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transactionDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serviceHandling() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
