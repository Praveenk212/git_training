package com.cg.obs.service;

import java.util.List;

import com.cg.obs.dao.AdminDao;
import com.cg.obs.dao.AdminDaoImpl;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao=new AdminDaoImpl();
	@Override
	public boolean login(String userName, String password) {
		
		return adminDao.login(userName, password);
	}
	
	@Override
	public String addCustomer(AccountDto accDto,UserDto userDto) {
		
		return adminDao.addCustomer(accDto,userDto);
	}

	@Override
	public String viewCustomerList() {
		
		return adminDao.viewCustomerList();
	}

	@Override
	public String transactionDetails() {
	
		return adminDao.transactionDetails();
	}

	@Override
	public String serviceHandling() {
		
		return null;
	}

	@Override
	public List<TransactionDto> yearlyTransactionDetails(long accNo) {
		
		return adminDao.yearlyTransactionDetails(accNo);
	}

	@Override
	public List<TransactionDto> quarterlyTransactionDetails(long accNo) {
		
		return adminDao.quarterlyTransactionDetails(accNo);
	}

	@Override
	public List<TransactionDto> monthlyTransactionDetails(long accNo) {
		
		return adminDao.monthlyTransactionDetails(accNo);
	}

	@Override
	public List<TransactionDto> allYearlyTransactionDetails() {
		
		return adminDao.allYearlyTransactionDetails();
	}

	@Override
	public List<TransactionDto> allQuarterlyTransactionDetails() {
		
		return adminDao.allQuarterlyTransactionDetails();
	}

	@Override
	public List<TransactionDto> allMonthlyTransactionDetails() {
		
		return adminDao.allMonthlyTransactionDetails();
	}

	

	
}
