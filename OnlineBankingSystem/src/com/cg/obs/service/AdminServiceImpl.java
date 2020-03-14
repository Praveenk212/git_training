package com.cg.obs.service;

import com.cg.obs.dao.AdminDao;
import com.cg.obs.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao=new AdminDaoImpl();
	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return adminDao.login(userName, password);
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
