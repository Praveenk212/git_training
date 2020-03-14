package com.cg.obs.dao;

import java.util.HashMap;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.UserDto;

public class StaticCustomerDb {
	
	public static HashMap<AccountDto,UserDto> customerDb=new HashMap<AccountDto,UserDto>();
	
	static
	{
		customerDb.put(new AccountDto("soham1808",50000,"0"), new UserDto("soham1808","Soham@1808","Soham Purohit",22,"Male",
				"soham@gmail.com","Bikaner",1234567890L,8288053888L));
		
		customerDb.put(new AccountDto("praveen012",10000,"0"), new UserDto("praveen012","Praveen@012","Praveen Kumar",25,"Male",
				"praveen@gmail.com","Bihar",2345678901L,9299653888L));	
		customerDb.put(new AccountDto("pooja3004",1000000000,"0"), new UserDto("pooja3004","Pooja@3004","Pooja Devi",21,"FeMale",
				"pooja@gmail.com","Haryana",2345678901L,9299653888L));	
		customerDb.put(new AccountDto("om012",100000,"0"), new UserDto("om012","om@012","om lodu",21,"Male",
				"om@gmail.com","Kanpur",2345678901L,9299653888L));	
	}
	public static HashMap<AccountDto, UserDto> getCustomerDb() 
	{
		return customerDb;
	}

	public static void setCustomerDb(HashMap<AccountDto, UserDto> customerDb) {
		StaticCustomerDb.customerDb = customerDb;
	}

	
}
