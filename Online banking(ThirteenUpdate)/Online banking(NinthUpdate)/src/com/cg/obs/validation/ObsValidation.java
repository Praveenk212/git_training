package com.cg.obs.validation;

public class ObsValidation 
{
	public boolean isDigit(String id)
	{
	String regex = "[0-9]";
	return id.matches(regex);
	}
	
	public boolean checkUserName(String userName)
	{
		String regex ="^[a-z0-9_-]{3,15}$";
		return userName.matches(regex);
	}
	
	public boolean checkPassword(String password)
	{
		String regex="((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
		return password.matches(regex);
	}

	
}
