package com.cg.obs.dao;

public interface AdminDao {
	
	public boolean login(String userName,String password);
	
	public String addCustomer();
	public String viewCustomerList();
	public String transactionDetails();
	public String serviceHandling();

}
 