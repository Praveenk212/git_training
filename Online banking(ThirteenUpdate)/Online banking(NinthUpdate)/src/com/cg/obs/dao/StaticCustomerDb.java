package com.cg.obs.dao;

import java.util.HashMap;

import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.UserDto;

public class StaticCustomerDb 
{
	
	
//*****Declaration of static data for customer information and put it in Data Structure(HashMap):*******
	
	
	public static HashMap<AccountDto,UserDto> customerDb=new HashMap<AccountDto,UserDto>();
	
	static
	{
		customerDb.put(new AccountDto("soham1808",50000,0), 
				new UserDto("soham1808","Soham@1808","Soham Purohit",22,
				"Male","soham@gmail.com","Bikaner",1234567890L,8288053888L));
		
		customerDb.put(new AccountDto("praveen012",60000,0),
				new UserDto("praveen012","Praveen@012","Praveen Kumar",25,
				"Male","praveen@gmail.com","Bihar",2345675645L,9299653888L));
		
		customerDb.put(new AccountDto("deepanshu07",50000,0),
				new UserDto("deepanshu07","deepanshu@07","Deepanshu Pathak",21,
				"Male","soham@gmail.com","Jabalpur",1234563424L,4412786555L));
		
		customerDb.put(new AccountDto("Prerak12",70000,0), new UserDto("Prerak12","Prerak12@012","Prerak Agrawal",22,"Male",
				"praveen@gmail.com","Dehradun",234565646L,92996567865L));
		
		customerDb.put(new AccountDto("subham1202",66000,0), 
				new UserDto("subham1202","subhs@02","Shubham Banshal",22,
				"Male","soham@gmail.com","Mohali",1234566756L,8288067569L));
		
		customerDb.put(new AccountDto("HariMani122",44000,0),
				new UserDto("HariMani122","Hari@22","HariMani",23,
				"Male","praveen@gmail.com","Tamilnadu",2345667564L,929956453L));
		
		customerDb.put(new AccountDto("Rajat566",45000,0), 
				new UserDto("Rajat566","Rajat@566","Rajat Sareen",22,
				"Male","soham@gmail.com","Amritsar",1234567890L,8288034212L));
		
		customerDb.put(new AccountDto("Ashish566",60000,0),
				new UserDto("Ashish566","Praveen@012","Ashish Kumar",21,
				"Male","praveen@gmail.com","Mathura",2345667543L,92996655534L));
		
		
		customerDb.put(new AccountDto("Shivam122",45000,0),
				new UserDto("Shivam122","Shivam@122","Shivam Singh",22,
				"Male","soham@gmail.com","Bikaner",1234564534L,8288034534L));
		
		customerDb.put(new AccountDto("Sudhanshu202",65000,0),
				new UserDto("Sudhanshu202","Sudhanshu@202","Shudhanshu Rajpal",21,
				"Male","praveen@gmail.com","Haryana",2345677867L,9299612135L));
			
	}

	
	
	
//************Getter and setter function for customerDb (Account holder Information HashMap)************	
	
	
	public static HashMap<AccountDto, UserDto> getCustomerDb()
	{
		return customerDb;
	}

	public static void setCustomerDb(HashMap<AccountDto, UserDto> customerDb)
	{
		StaticCustomerDb.customerDb = customerDb;
	}
}
