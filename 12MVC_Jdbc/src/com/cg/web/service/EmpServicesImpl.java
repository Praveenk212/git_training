package com.cg.web.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class EmpServicesImpl implements EmpServices{
	
	
	@Override
	public String authenticate(String userName,String passWord)
	{
		
		if(userName.equals("aa") && (passWord.equals("bb")))
				{
			return "aa bb ccc";
				}
		else
			return null;
		
		
	}
	

}
