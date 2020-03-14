package com.cg.obs.ui;

import java.util.Scanner;

import com.cg.obs.dao.StaticCustomerDb;
import com.cg.obs.dao.StaticTransferDb;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;
import com.cg.obs.service.AdminService;
import com.cg.obs.service.AdminServiceImpl;
import com.cg.obs.service.CustomerService;
import com.cg.obs.service.CustomerServiceImpl;

public class ObsMain {

	public static void main(String[] args) 
	{

		CustomerService custservice=new CustomerServiceImpl();

		AdminService adminService=new AdminServiceImpl();

		StaticCustomerDb custDb=new StaticCustomerDb();
		StaticTransferDb transDb=new StaticTransferDb();
		System.out.println(custDb.customerDb+"\n");
		System.out.println(transDb.transactionDb);

		Scanner sc=new Scanner(System.in);

		while(true)					// Opening of main menu while loop
		{
			System.out.println("\n\n\n\n\n\t****************************WELCOME TO ONLINE BANKING SYSTEM*************************");
			System.out.println("\n\n\n\t\tPress 1 : To login as a Admin");
			System.out.println("\t\tPress 2 : To login as a Customer\n\n\t");
			System.out.print("\t\tEnter Your Choice  : \t");

			boolean temp=true;
			int id=sc.nextInt();

			//*****************************Admin Part************************************


			if(id==1)					//opening of admin menu
			{
				System.out.print("\n\n\t\tplease Enter your User Name   : ");
				String userName=sc.next();
				System.out.print("\t\tplease Enter your Password    : ");
				String password=sc.next();
				System.out.println(userName+" "+password);
				boolean adminReq=adminService.login(userName,password);


				if(adminReq==false)
				{
                   System.out.println("Not a valid Admin");
				}
				else
				{

					while(adminReq)
					{
						System.out.println("\n\n\t\t\t\t1 : To View Customers List");
						System.out.println("\t\t\t\t2 : To Create a New Accout On Customer Request");
						System.out.println("\t\t\t\t3 : To Check the Transaction Report of Customers");
						System.out.println("\t\t\t\t4 : To Accept the Cusotmer's Service Request");
						System.out.println("\t\t\t\t5 : To Return to Main Page");

						System.out.print("\n\t\t\t\tEnter Your Choice  : ");
						int adminReq1=sc.nextInt();
						switch(adminReq1)
						{
						case 1:
						{
							System.out.println("\t\t\t\t\t\tView Customer List service is under progress");

							break;
						}
						case 2:
						{
							String newUserName=null;
							String newPassword=null;
							boolean formReq=true;
							while(formReq)		//opening of while loop of account form
							{
								System.out.println("\n\n\t\t\t\t\tPress 1: To fill the form");
								System.out.println("\t\t\t\t\tPress 2: Go to previous menu");
								System.out.println("\n\n");
								System.out.print("\t\t\t\t\tEnter Your Choice  : ");
								int formData=sc.nextInt();
								switch(formData)	//opening of account form switch case 
								{
								case 1:
								{
									System.out.println("\n\t\t\t\t\t\tFollowing Requirement needed:\n");
									System.out.println("  \t\t\t\t\t\t1:Customer Full Name*");
									System.out.println("  \t\t\t\t\t\t2:Customer Age*");
									System.out.println("  \t\t\t\t\t\t3:Customer gender*");
									System.out.println("  \t\t\t\t\t\t4:Address*");
									System.out.println("  \t\t\t\t\t\t5:Mobile No.*");
									System.out.println("  \t\t\t\t\t\t6:Aadhar No*");
									System.out.println("  \t\t\t\t\t\t7:Customer Email ID");

									System.out.print("\n\n\t\t\t\t\t\tEnter Customer Name: ");
									String custName=sc.next();
									if(custName.length()>0)
									{
										System.out.print("\t\t\t\t\t\tEnter Customer Age: ");
										int custAge=sc.nextInt();
										System.out.print("\t\t\t\t\t\tEnter Customer Gender: ");
										String custGender=sc.next();
										if(custGender.length()>0)
										{
											System.out.print("\t\t\t\t\t\tEnter Customer Address: ");
											String custAddress=sc.next();
											if(custAddress.length()>0)
											{
												System.out.print("\t\t\t\t\t\tEnter Customer Contact No: ");
												long custMobileNo=sc.nextLong();
												if(custMobileNo>0)
												{
													System.out.print("\t\t\t\t\t\tEnter Customer Aadhar No: ");
													long custAadharNo=sc.nextLong();
													if(custAadharNo>0)
													{

														boolean emailReq=true;
														while(emailReq)
														{
															System.out.println("\t\t\t\t\t\tDo you want to add Email id");
															System.out.println("\n\n\t\t\t\t\t\tPress 1 : To Add Email");
															System.out.println("\t\t\t\t\t\tPress 2 : Complete the process");

															System.out.println("\n\n");
															System.out.print("\t\t\t\t\t\tEnter Your Choice  : ");
															int Request = sc.nextInt();

															switch(Request)
															{
															case 1:
															{
																System.out.print("\t\t\t\t\t\tEnter Customer Email Id: ");
																String custEmailId=sc.next();
																if(custEmailId.length()>0)
																{
																	System.out.println("\n\t\t\t\t\t\t*****Your account has been created successfully******\n");
																	System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																	newUserName=sc.next();
																	System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																	newPassword=sc.next();

																	System.out.println("\n\t\t\t\t*****THANK YOU FOR CREATING AN ACCOUNT*****");
																	emailReq=false;
																}
																else
																{
																	System.out.println("\t\t\t\t\t\tplease enter the valid email");

																}
																break;

															}
															case 2:
															{
																emailReq=false;
																System.out.println("\n\t\t\t\t\t\t*****Your account has been created successfully******\n");
																break;
															}
															default:
															{
																System.out.println("\t\t\t\t\t\tEnter the right choice");
															}
															}	//email switch case
														}	// email while loop

													}
													else
													{
														System.out.println("\t\t\t\t\t\tplease enter the valid Aadhar No");
													}
												}
												else
												{
													System.out.println("\t\t\t\t\t\tplease enter the valid Contact No");
												}
											}
											else
											{
												System.out.println("\t\t\t\t\t\tplease enter the valid Address");
											}
										}
										else
										{
											System.out.println("\t\t\t\t\t\tplease enter the right choice");
										}
									}
									else
									{
										System.out.println("\t\t\t\t\t\tplease enter the valid Customer Name");
									}
									break;
								}
								case 2:
								{
									formReq=false;
									break;
								}
								default:
								{
									System.out.println("\t\t\t\t\t\tyou have entered the wrong choice");
								}
								}				// account form switch ended
								//System.out.println("\t\t\t\t\t\tCreate a New Account On Customer Request service is under progress");

							}
							break;
						}

						case 3:
						{
							System.out.println("\t\t\t\t\t\tCheck the Transaction Report of Customers service is under progress");
							break;
						}
						case 4:
						{
							System.out.println("\t\t\t\t\t\tCheck the Transaction Report of Customers service is under progress");
							break;
						}
						case 5:
						{
							adminReq=false;
							break;
						}
						default:
						{
							System.out.println("\t\t\t\t\t\tYou have entered the wrong choice");
						}
						}				//admin switch case closed
					}				//admin while loop closed	


				}	
			}//ending of admin menu


			//*****************************Customer Part************************************


			else if(id==2)					// opening of customer menu else part
			{
				boolean custRequest=true;
				while(custRequest)				//opening of customer menu while loop
				{
					System.out.println("\n\n\t\t\t\t1 : To create new account");
					System.out.println("\t\t\t\t2 : To Login your account");
					System.out.println("\t\t\t\t3 : Go back to Main menu");
					System.out.println("\n\n");
					System.out.print("\t\t\t\tEnter Your Choice  : ");

					int custAccount=sc.nextInt();
					String newUserName=null;
					String newPassword=null;
					switch(custAccount)
					{

					case 1: 	
					{
						boolean formReq=true;
						while(formReq)		//opening of while loop of account form
						{
							System.out.println("\n\n\t\t\t\t\tPress 1: To fill the form");
							System.out.println("\t\t\t\t\tPress 2: Go to previous menu");
							System.out.println("\n\n");
							System.out.print("\t\t\t\t\tEnter Your Choice  : ");
							int formData=sc.nextInt();
							switch(formData)	//opening of account form switch case 
							{
							case 1:
							{
								UserDto userDto=new UserDto();

								System.out.println("\n\t\t\t\t\t\tFollowing Requirement needed:\n");
								System.out.println("  \t\t\t\t\t\t1:Customer Full Name*");
								System.out.println("  \t\t\t\t\t\t2:Customer Age*");
								System.out.println("  \t\t\t\t\t\t3:Customer gender*");
								System.out.println("  \t\t\t\t\t\t4:Address*");
								System.out.println("  \t\t\t\t\t\t5:Mobile No.*");
								System.out.println("  \t\t\t\t\t\t6:Aadhar No*");
								System.out.println("  \t\t\t\t\t\t7:Customer Email ID");

								System.out.print("\n\n\t\t\t\t\t\tEnter Customer Name: ");
								String custName=sc.next();
								if(custName.length()>0)
								{
									userDto.setCustName(custName);
									System.out.print("\t\t\t\t\t\tEnter Customer Age: ");
									int custAge=sc.nextInt();
									userDto.setAge(custAge);
									System.out.print("\t\t\t\t\t\tEnter Customer Gender: ");
									String custGender=sc.next();
									if(custGender.length()>0)
									{
										userDto.setGender(custGender);
										System.out.print("\t\t\t\t\t\tEnter Customer Address: ");
										String custAddress=sc.next();
										if(custAddress.length()>0)
										{
											userDto.setAddress(custAddress);
											System.out.print("\t\t\t\t\t\tEnter Customer Contact No: ");
											long custMobileNo=sc.nextLong();
											if(custMobileNo>999999999)
											{
												userDto.setPhoneNo(custMobileNo);
												System.out.print("\t\t\t\t\t\tEnter Customer Aadhar No: ");
												long custAadharNo=sc.nextLong();
												if(custAadharNo>0)
												{
													userDto.setAadharNo(custAadharNo);

													boolean emailReq=true;
													while(emailReq)
													{
														System.out.println("\t\t\t\t\t\tDo you want to add Email id");
														System.out.println("\n\n\t\t\t\t\t\tPress 1 : To Add Email");
														System.out.println("\t\t\t\t\t\tPress 2 : Complete the process");

														System.out.println("\n\n");
														System.out.print("\t\t\t\t\t\tEnter Your Choice  : ");
														int Request = sc.nextInt();

														switch(Request)
														{
														case 1:
														{
															System.out.print("\t\t\t\t\t\tEnter Customer Email Id: ");
															String custEmailId=sc.next();
															if(custEmailId.length()>0)
															{
																userDto.setEmailId(custEmailId);
																System.out.println("\n\t\t\t\t\t\t*****Your account has been created successfully******\n");
																System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																newUserName=sc.next();
																userDto.setUserName(newUserName);
																System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																newPassword=sc.next();
																userDto.setPassword(newPassword);
																System.out.println("\n\t\t\t\t*****THANK YOU FOR CREATING AN ACCOUNT*****");
																emailReq=false;
															}
															else
															{
																System.out.println("\t\t\t\t\t\tplease enter the valid email");

															}
															break;

														}
														case 2:
														{
															emailReq=false;
															System.out.println("\n\t\t\t\t\t\t*****Your account has been created successfully******\n");
															break;
														}
														default:
														{
															System.out.println("\t\t\t\t\t\tEnter the right choice");
														}
														}	//email switch case
													}	// email while loop

												}
												else
												{
													System.out.println("\t\t\t\t\t\tplease enter the valid Aadhar No");
												}
											}
											else
											{
												System.out.println("\t\t\t\t\t\tplease enter the valid Contact No");
											}
										}
										else
										{
											System.out.println("\t\t\t\t\t\tplease enter the valid Address");
										}
									}
									else
									{
										System.out.println("\t\t\t\t\t\tplease enter the right choice");
									}
								}
								else
								{
									System.out.println("\t\t\t\t\t\tplease enter the valid Customer Name");
								}
								AccountDto accDto=new AccountDto(userDto.getUserName(),0,"0");
								custservice.addCustomer(accDto, userDto);
								//custDb.customerDb.put(accDto, userDto);

								break;
							}
							case 2:
							{
								formReq=false;
								break;
							}
							default:
							{
								System.out.println("\t\t\t\t\t\tyou have entered the wrong choice");
							}
							}				// account form switch ended
						}				//account form while loop ended
						//System.out.println("\n\t\t\t\t\t\tCreate account service is under progress");

						break;
					}
					case 2:
					{	sc.nextLine();
					System.out.print("\n\n\t\t\t\tplease Enter your User Name  : ");
					String userName=sc.nextLine();
					System.out.print("\t\t\t\tplease Enter your Password       : ");
					String password=sc.nextLine();
					System.out.println(userName);
					System.out.println(password);
					boolean custRequest1=custservice.custLogin(userName,password);
					if(custRequest1==false)
					{
						System.out.println("\n\n\t\t\t\t\t\t1 Wrong UserName and Password");
					}
					else
					{
						while(custRequest1)						//opening of customer menu while loop
						{
							System.out.println("\n\n\t\t\t\t\t\t1 : To View Account Details");
							System.out.println("\t\t\t\t\t\t2 : To Transfer the Money");
							System.out.println("\t\t\t\t\t\t3 : To Update the Personal details");
							System.out.println("\t\t\t\t\t\t4 : To Request for credit card or cheque book");
							System.out.println("\t\t\t\t\t\t5 : To check the status of your previous requests");
							System.out.println("\t\t\t\t\t\t6 : To Return to Main Page");

							System.out.print("\n\t\t\t\t\t\tEnter Your Choice  : ");
							int custService=sc.nextInt();

							switch(custService)				// opening of customer menu switch case:
							{
							case 1:
							{
								boolean custRequest2=true;
								while(custRequest2)			// customer  details while loop opened
								{

									System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : for  statement");
									System.out.println("\t\t\t\t\t\t\t\tPress 2 : for Summary");
									System.out.println("\t\t\t\t\t\t\t\tPress 3 : for view Personal details");
									System.out.println("\t\t\t\t\t\t\t\tPress 4 : for going to previous menu");

									System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
									int custDetail=sc.nextInt();

									switch(custDetail)			//opening of customer details switch case
									{

									case 1:
									{
										System.out.println("\t\t\t\t\t\t\t\t"+custservice.viewStatement(userName));

										break;
									}
									case 2:
									{
										System.out.println("\t\t\t\t\t\t\t\t"+custservice.viewSummary(userName));

										break;
									}
									case 3:
									{
										System.out.println("\t\t\t\t\t\t\t\t"+custservice.viewPersonalDetails(userName));
										break;
									}
									case 4:
									{
										custRequest2=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\tYou have enter the wrong choice!");
										break;
									}
									}					//ending of customer details switch case
								}				//ending of customer details While loop
								break;
							}
							case 2:
							{
								boolean custRequest3=true;
								while(custRequest3)			// customer  transfer while loop opened
								{
									System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : Transfer in Same bank");
									System.out.println("\t\t\t\t\t\t\t\tPress 2 : Transfer in different bank");
									System.out.println("\t\t\t\t\t\t\t\tPress 3 : for going to previous menu");

									System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
									int custTransfer=sc.nextInt();

									switch(custTransfer)			//opening of customer transfer switch case
									{
									case 1:
									{
										System.out.println("\t\t\t\t\t\t\t\tTransfer in Same bank service is under progress");
										System.out.println("Enter the account number on which you want transfer:");
										Long receiverAccNo=sc.nextLong();
										String senderUserName=userName;
										System.out.println("Enter amount to transfer:");
										float amount=sc.nextFloat();

										System.out.println(custservice.transferAmt(senderUserName,receiverAccNo,amount));


										break;
									}
									case 2:
									{
										System.out.println("\t\t\t\t\t\t\t\tTransfer in different bank is under progress");
										break;
									}
									case 3:
									{
										custRequest3=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\tYou have enter the wrong choice!");
										break;
									}
									}						//ending of customer transfer switch case
								}					//ending of customer transfer While loop
								break;
							}
							case 3:
							{
								boolean custRequest4=true;
								while(custRequest4)			// customer  update while loop opened
								{
									System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : Password update");
									System.out.println("\t\t\t\t\t\t\t\tPress 2 : Contact No update");
									System.out.println("\t\t\t\t\t\t\t\tPress 3 : Email update");
									System.out.println("\t\t\t\t\t\t\t\tPress 4 : Address update");
									System.out.println("\t\t\t\t\t\t\t\tPress 5 : for going to previous menu");

									System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
									int custUpdate=sc.nextInt();

									switch(custUpdate)			//opening of customer update switch case
									{
									case 1:
									{
										/*System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
											String updateuserName=sc.next();*/
										System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New password : ");
										String updatepassword=sc.next();

										String passwordMessage=custservice.updatepassword(userName,updatepassword);
										System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+passwordMessage);

										break;
									}
									case 2:
									{
										/*System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
											String updateuserName=sc.next();*/
										System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Contact No. : ");
										long updateContactNo=sc.nextLong();

										String contactMessage=custservice.updateContactDetails(userName,updateContactNo);
										System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+contactMessage);
										break;
									}
									case 3:
									{
										/*System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
											String updateuserName=sc.next();*/
										System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Email : ");
										String updateEmail=sc.next();

										String EmailMessage=custservice.updateEmail(userName,updateEmail);
										System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+EmailMessage);
										break;
									}
									case 4:
									{
										/*System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
											String updateuserName=sc.next();*/
										System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Address : ");
										String updateAddress=sc.next();

										String addressMessage=custservice.updateAddress(userName,updateAddress);
										System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+addressMessage);
										break;
									}
									case 5:
									{
										custRequest4=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\t\t\tYou have enter the wrong choice!");
										break;
									}
									}						//ending of customer update switch case	
								}					// customer  update while loop closed
								break;
							}
							case 4:
							{
								boolean custRequest5=true;
								while(custRequest5)				// customer  request while loop opened
								{
									System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : Request for credit card");
									System.out.println("\t\t\t\t\t\t\t\tPress 2 : Request for cheque book");
									System.out.println("\t\t\t\t\t\t\t\tPress 3 : for going to previous menu");

									System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
									int custReq=sc.nextInt();

									switch(custReq)				//opening of customer request switch case
									{
									case 1:
									{
										System.out.println("\n\t\t\t\t\t\tplease fill the Form \n");


										System.out.print("\n\n\t\t\t\t\t\tEnter Customer Name: ");
										String custName=sc.next();
										if(custName.length()>0)
										{
											System.out.print("\t\t\t\t\t\tEnter Customer Age: ");
											int custAge=sc.nextInt();
											System.out.print("\t\t\t\t\t\tEnter Customer Gender: ");
											String custGender=sc.next();
											if(custGender.length()>0)
											{
												System.out.print("\t\t\t\t\t\tEnter Customer Address: ");
												String custAddress=sc.next();
												if(custAddress.length()>0)
												{
													System.out.print("\t\t\t\t\t\tEnter Customer Contact No: ");
													long custMobileNo=sc.nextLong();
													if(custMobileNo>0)
													{
														System.out.print("\t\t\t\t\t\tEnter Customer Aadhar No: ");
														long custAadharNo=sc.nextLong();
														if(custAadharNo>0)
														{

															System.out.print("\t\t\t\t\t\tEnter Customer Email Id: ");
															String custEmailId=sc.next();
															if(custEmailId.length()>0)
															{
																System.out.print("\t\t\t\t\t\tEnter Customer current city: ");
																String custCity=sc.next();
																if(custCity.length()>0)
																{
																	System.out.print("\t\t\t\t\t\tEnter Customer Annual Income: ");
																	long custIncome=sc.nextLong();
																	if(custIncome>0)
																	{
																		int requestId=custservice.requestCreditCard
																				(userName,custName,custAge,custGender,custAddress,custMobileNo,
																						custAadharNo,custEmailId,custCity,custIncome);

																		if(requestId==0)
																		{
																			System.out.println("\n\t\t\t\t\t\t\t\t\t\t You are not eligible for Credit card Service");
																		}
																		else
																		{
																			System.out.println("\n\t\t\t\t\t\t\t\tYour Request has been sent successfully");
																			System.out.println("\n\t\t\t\t\t\t\t\tThis is your Request Id :"+requestId);
																		}
																	}
																	else
																	{
																		System.out.println("\n\t\t\t\t\t\t\t\t\t\t please enter the valid Annual Income");
																	}
																}
																else
																{
																	System.out.println("\t\t\t\t\t\tplease enter the valid City Name");
																}
															}	
															else
															{
																System.out.println("\t\t\t\t\t\tplease enter the valid Email ID");
															}


														}
														else
														{
															System.out.println("\t\t\t\t\t\tplease enter the valid Aadhar No");
														}
													}
													else
													{
														System.out.println("\t\t\t\t\t\tplease enter the valid Contact No");
													}
												}
												else
												{
													System.out.println("\t\t\t\t\t\tplease enter the valid Address");
												}
											}
											else
											{
												System.out.println("\t\t\t\t\t\tplease enter the right choice");
											}
										}
										else
										{
											System.out.println("\t\t\t\t\t\tplease enter the valid Customer Name");
										}
										break;
									}
									case 2:
									{
										System.out.print("\n\t\t\t\t\t\t\t\t Please enter your account no: ");
										long accountNo=sc.nextLong();
										int requestId=custservice.requestChequeBook(userName,accountNo);
										if(requestId==0)
										{
											System.out.println("\n\t\t\t\t\t\t\t\t You are not eligible for Cheque Service");
										}
										else if(requestId==1)
										{
											System.out.println("\n\t\t\t\t\tAccount No and User Name does not match, Pleae enter the valid Details");
										}
										else
										{
											System.out.println("\n\t\t\t\t\t\t\t\tWe have Received your Request");
											System.out.println("\n\t\t\t\t\t\t\t\tThis is your Request Id :"+requestId);
										}
										break;
									}
									case 3:
									{
										custRequest5=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\t\t\tYou have enter the wrong choice!");
										break;
									}
									}				//ending of customer request switch case
								}				//ending of customer request while loop
								break;
							}
							case 5:
							{
								boolean custRequest6=true;
								while(custRequest6)				// customer  requestID while loop opened
								{
									System.out.println("\n\n\t\t\t\t\t\tPress 1 : Check the previous Request status");
									System.out.println("\t\t\t\t\t\tPress 2 : for going to previous menu");

									System.out.print("\n\n\t\t\t\t\t\t\tEnter your choice : ");
									int custReqId=sc.nextInt();


									switch(custReqId)		//opening of customer requestID switch case
									{
									case 1:
									{
										System.out.print("\n\t\t\t\t\t\t\t\tEnter the Request ID: ");
										int requestId=sc.nextInt();
										System.out.println("\t\t\t\t\t\t\t\t"+userName+" : "+password);
										System.out.println("\n\t\t\t\t\t\t\t\tRequest status service is under progress");
										break;
									}
									case 2:
									{
										custRequest6=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\tYou have enter the wrong choice!");
										break;
									}
									}			//ending of customer requestID switch case

								}			// customer  requestID while loop closed
								break;
							}
							case 6:
							{
								custRequest1=false;
								break;
							}
							default:
							{
								System.out.println("\t\t\t\t\t\t\t\tYou have entered the wrong choice");
								break;
							}
							}							//Login part switch closed

						}							//Login part while loop closed
						break;
					}
					}
					case 3:
					{
						custRequest=false;
						break;
					}
					default:
					{
						System.out.println("\t\tYou have enter the wrong choice");
						break;
					}
					}						// Ending of Customer switch case
				}						// Ending of Customer menu While Loop
			}						// Ending of Customer Main Menu else if
			else
			{
				System.out.println("You have entered the wrong choice");
			}

		}					//Ending of Main While Loop

	}			// Ending of Main function

}		//Ending of Main public Class}		//Ending of Main public Class