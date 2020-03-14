package com.cg.obs.service;

public interface AdminService {
	
	
	public boolean login(String userName,String password);
	
	public String addCustomer();
	public String viewCustomerList();
	public String transactionDetails();
	public String serviceHandling();

}
