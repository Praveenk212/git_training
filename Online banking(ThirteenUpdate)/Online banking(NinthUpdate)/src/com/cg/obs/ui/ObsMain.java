package com.cg.obs.ui;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.cg.obs.dao.AdminDao;
import com.cg.obs.dao.StaticCustomerDb;
import com.cg.obs.dao.StaticTransferDb;
import com.cg.obs.dto.AccountDto;
import com.cg.obs.dto.Addtionaliformation;
import com.cg.obs.dto.TransactionDto;
import com.cg.obs.dto.UserDto;
import com.cg.obs.service.AdminService;
import com.cg.obs.service.AdminServiceImpl;
import com.cg.obs.service.CustomerService;
import com.cg.obs.service.CustomerServiceImpl;
import com.cg.obs.validation.ObsValidation;

public class ObsMain {

	public static void main(String[] args) 
	{
		//Object creation of all classes;
		
			ObsValidation valid=new ObsValidation();
		
			CustomerService custServices=new CustomerServiceImpl();
			
			AdminService adminServices=new AdminServiceImpl();
			
			Scanner sc=new Scanner(System.in);
			
			UserDto userDto=new UserDto();
			
				
			//Perform Operations:	
			
			while(true)					// Opening of main menu while loop
			{ 
				/*System.out.println("\n\n\n----------------------------*       *");
				System.out.println("-----------------------------*  *  *");
				System.out.println("------------------------------*  *");*/
				System.out.println("\n\n\n****************************WELCOME TO ONLINE BANKING SYSTEM*************************");
				System.out.println("\n\n\n\tPress 1 : To login as a Admin");
				System.out.println("\tPress 2 : To login as a Customer");
				System.out.println("\tPress 3 : To Exit from a System\n\n\t");
				System.out.print("\tEnter Your Choice  : \t");
				
				boolean temp=true;
				String id=sc.next();

				if(valid.isDigit(id))
				{
				//*****************************Admin Part************************************


				if(Integer.parseInt(id)==1)					//opening of admin menu
				{
					System.out.print("\n\n\t\tplease Enter your User Name   : ");
					String userName=sc.next();
					if(valid.checkUserName(userName))
					{	
						System.out.print("\t\tplease Enter your Password    : ");
						String password=sc.next();
					if(valid.checkPassword(password))
					{
						boolean adminReq=true;
						while(adminReq)
						{
							System.out.println("\n\n\t\t\t\t1 : To View Customers List");
							System.out.println("\t\t\t\t2 : To Create a New Accout On Customer Request");
							System.out.println("\t\t\t\t3 : To Check the Transaction Report of Customers");
							System.out.println("\t\t\t\t4 : To See the Customer's Request");
							System.out.println("\t\t\t\t5 : To Return to Main Page");

							System.out.print("\n\t\t\t\tEnter Your Choice  : ");
							int adminReq1=sc.nextInt();
							switch(adminReq1)
							{
							case 1:
							{
								HashMap<AccountDto,UserDto> DetailList=adminServices.viewCustomerList();
								System.out.println("\n\n\t\t\t\t|---------------|-----------------------|-------------------------------------|");
								System.out.println("\t\t\t    \t|Account No.    |   \tUser Name       | \tCurrent Balance\t\t      |\n");
								for(Map.Entry<AccountDto, UserDto> entry:DetailList.entrySet())
								{
									AccountDto key=entry.getKey();
									UserDto value=entry.getValue();
									if(key.getBalance()<10000)
									{
										System.out.println("\t\t\t\t|---------------|-----------------------|-------------------------------------|\n");
										System.out.println("\t\t\t\t|"+key.getAccNo()+"\t|\t"+key.getUserName()+"\t|\t  "+key.getBalance()+"\t\t\t      |");
									}
									else
									{
										System.out.println("\t\t\t\t|---------------|-----------------------|-------------------------------------|\n");
										System.out.println("\t\t\t\t|"+key.getAccNo()+"\t|\t"+key.getUserName()+"\t|\t  "+key.getBalance()+"\t\t      |");
									}
								}	
								System.out.println("\t\t\t\t|---------------|-----------------------|-------------------------------------|\n");
								boolean viewDetail=true;
								while(viewDetail)
								{
									System.out.println("\n\n\t\t\t\tPress 1: To View Detail of Customer");
									System.out.println("\t\t\t\tPress 2: Go to previous menu");
									System.out.print("\n\n\t\t\t\tEnter Your Choice  : ");
									int viewChoice=sc.nextInt();
									
									switch(viewChoice)
									{
										case 1:
										{
											System.out.print("\n\n\t\t\t\tEnter the Customer User Name : ");
											String custUserName=sc.next();
											String viewPersonalDetails=custServices.viewPersonalDetails(custUserName);
											System.out.print("\n\t\t\t\t\t|---------------------------------------------------|");
											System.out.print(viewPersonalDetails);
											System.out.println("\t\t\t\t\t|---------------------------------------------------|\n");
											break;
										}
										case 2:
										{
											viewDetail=false;
											break;
										}
										default:
										{
											System.out.println("\n\t\t\t\t\tPlease enter the valid choice..");
											break;
										}
									}
								}
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
																				//System.out.println("\n\t\t\t\t\t\t*****Your account has been created successfully******\n");
																				System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																				newUserName=sc.next();
																				System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																				newPassword=sc.next();
																				
																				String newAccount=adminServices.addCustomer(newUserName,newPassword,
																				custName,custAge,custGender,custAddress,custMobileNo,custAadharNo,custEmailId);
																				
																				System.out.println("\n\t\t\t\t\t\t*****"+newAccount+"******\n");
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
																			System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																			newUserName=sc.next();
																			System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																			newPassword=sc.next();
																			
																			String newAccount=adminServices.addCustomer(newUserName,newPassword,
																			custName,custAge,custGender,custAddress,custMobileNo,custAadharNo,null);
																			
																			System.out.println("\n\t\t\t\t\t\t*****"+newAccount+"******\n");
																			System.out.println("\n\t\t\t\t*****THANK YOU FOR CREATING AN ACCOUNT*****");
																			emailReq=false;
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
							
							}
							break;
						}

						case 3:
						{
							boolean transactionFlag=true;
							while(transactionFlag)
							{
								System.out.println("\n\n\t\t\t\t\tPress 1: All Customers transactions:");
								System.out.println("\t\t\t\t\tPress 2: Transactions By Account no:");
								System.out.println("\t\t\t\t\tPress 3: Go to previous menu");
								System.out.print("\n\t\t\t\t\tEnter your choice:");
								int transactionChoice=sc.nextInt();
						
								switch(transactionChoice)
								{
								case 1:
								{
									
									boolean reportCheck=true;
									while(reportCheck)
									{
						
										System.out.println("\n\n\t\t\t\t\t\tPress 1: To See Monthly Report");
										System.out.println("\t\t\t\t\t\tPress 2: To see quarterly Report");
										System.out.println("\t\t\t\t\t\tPress 3: To see Yearly Report");
										System.out.println("\t\t\t\t\t\tPress 4: Go to previous menu");
										System.out.print("\n\n\t\t\t\t\t\tEnter Your Choice  : ");
										int reportChoice=sc.nextInt();
					
										switch(reportChoice)
										{
											case 1:
											{
												List<TransactionDto> transactionReport=adminServices.allMonthlyTransactionDetails();
												if(transactionReport.isEmpty())
												{
													System.out.println("\n\t\t\t\t\t\tno transaction yet");
												}
									
												else
												{
													System.out.println("\n\n\t\t\t\tList of all monthly transactions:");
													float totalTransfer=0.0f;
													System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
													for(TransactionDto td:transactionReport)
													{
														totalTransfer+=td.getAmtTransfer();
														System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
													}
													System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\tTotal monthly Transactions"+" : "+totalTransfer);
													System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
												}
												break;
											}
											case 2:
											{
												List<TransactionDto> transactionReport=adminServices.allQuarterlyTransactionDetails();
												if(transactionReport.isEmpty())
												{
													System.out.println("\n\t\t\t\t\t\tno transaction yet");
												}
									
												else
												{
													System.out.println("\n\n\t\t\t\tList of all quarterly transactions:");
													float totalTransfer=0.0f;
													System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
													for(TransactionDto td:transactionReport)
													{
														totalTransfer+=td.getAmtTransfer();
														System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
													}
													System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\tTotal Quarterly Transactions"+" : "+totalTransfer);
													System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
												
												}
												break;
											}
											case 3:
											{
												List<TransactionDto> transactionReport=adminServices.allYearlyTransactionDetails();
												if(transactionReport.isEmpty())
												{
													System.out.println("\n\t\t\t\t\t\tno transaction yet");
												}
									
												else
												{
													System.out.println("\n\n\t\t\t\tList of all yearly transactions:");
													float totalTransfer=0.0f;
													System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
													for(TransactionDto td:transactionReport)
													{
														totalTransfer+=td.getAmtTransfer();
														System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
													}
													System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\tTotal Yealy Transactions"+" : "+totalTransfer);
													System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
												}
												break;
											}
											case 4:
											{
												reportCheck=false;
												break;
											}
											default:
											{
												break;
											}
										}
									}

									break;
								}
									case 2:
									{
										System.out.print("\n\n\t\t\t\t\t\tEnter the Customer Account No. : ");
										long accNo=sc.nextLong();
										boolean reportCheck=true;
										while(reportCheck)
										{
							
											System.out.println("\n\n\t\t\t\t\t\tPress 1: To See Monthly Report");
											System.out.println("\t\t\t\t\t\tPress 2: To see quarterly Report");
											System.out.println("\t\t\t\t\t\tPress 3: To see Yearly Report");
											System.out.println("\t\t\t\t\t\tPress 4: Go to previous menu");
											System.out.print("\n\n\t\t\t\t\t\tEnter Your Choice  : ");
											int reportChoice=sc.nextInt();
						
											switch(reportChoice)
											{
												case 1:
												{
													List<TransactionDto> transactionReport=adminServices.monthlyTransactionDetails(accNo);
													if(transactionReport.isEmpty())
													{
														System.out.println("\n\t\t\t\t\t\t  Account No does not match");
													}
										
													else if(transactionReport.get(0).getUsername()=="a")
													{
														System.out.println("\n\t\t\t\t\t\tno transaction yet");
													}
													else
													{
														System.out.println("\n\n\t\t\t\tList of all monthly transactions of Customer:");
														float totalTransfer=0.0f;
														System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
														for(TransactionDto td:transactionReport)
														{
															totalTransfer+=td.getAmtTransfer();
															System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
														}
														System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
														System.out.println("\t\t\t\tTotal Monthly Transactions of customer"+" : "+totalTransfer);
														System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
													
													}
													break;
												}
												case 2:
												{
													List<TransactionDto> transactionReport=adminServices.quarterlyTransactionDetails(accNo);
													if(transactionReport.isEmpty())
													{
														System.out.println("\n\t\t\t\t\t\t  Account No does not match");
													}
										
													else if(transactionReport.get(0).getUsername()=="a")
													{
														System.out.println("\n\t\t\t\t\t\tno transaction yet");
													}
													else
													{
														System.out.println("\n\n\t\t\t\tList of all quarterly transactions of Customer:");
														float totalTransfer=0.0f;
														System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
														for(TransactionDto td:transactionReport)
														{
															totalTransfer+=td.getAmtTransfer();
															System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
														}
														System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
														System.out.println("\t\t\t\tTotal Quarterly Transactions of customer"+" : "+totalTransfer);
														System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
													
													}
													break;
												}
												case 3:
												{
													List<TransactionDto> transactionReport=adminServices.yearlyTransactionDetails(accNo);
													if(transactionReport.isEmpty())
													{
														System.out.println("\n\t\t\t\t\t\t  Account No does not match");
													}
										
													else if(transactionReport.get(0).getUsername()=="a")
													{
														System.out.println("\n\t\t\t\t\t\tno transaction yet");
													}
													else
													{
														System.out.println("\n\n\t\t\t\tList of all yearly transactions of Customer:");
														float totalTransfer=0.0f;
														System.out.println("\n\t\t\t\tUserName\tDate Of Transfer\tTransaction Amount\tCurrent Balance\n");
														for(TransactionDto td:transactionReport)
														{
															totalTransfer+=td.getAmtTransfer();
															System.out.println("\t\t\t\t"+td.getUsername()+"\t"+td.getDate()+"\t\t"+td.getAmtTransfer()+"\t\t  \t"+td.getBalance());
														}
														System.out.println("\n\t\t\t\t----------------------------------------------------------------------------------");
														System.out.println("\t\t\t\tTotal Yealy Transactions of customer"+" : "+totalTransfer);
														System.out.println("\t\t\t\t----------------------------------------------------------------------------------");
													
													}
													break;
												}
												case 4:
												{
													reportCheck=false;
													break;
												}
												default:
												{
													break;
												}
											}
										}
									break;
									}
									case 3:
									{
										transactionFlag=false;
										break;
									}
									default:
									{
										System.out.println("\t\t\t\t\t\t\t\tPlease enter the right choice!");
										break;
									}
										
								}
							}
							break;
						}
						case 4:
						{
							HashMap<Integer,AccountDto> acceptRequest=adminServices.serviceHandling();
							if(acceptRequest.isEmpty())
							{
								System.out.println("\n\t\t\t\t\t\tNo pending request");
							}
							else
							{
								System.out.println("\n\t\t\t\t|--------------------------------------------------------------|");
								System.out.println("\t\t\t\t|Request Id \t \t  Request Type    \t  Request Date |");
								System.out.println("\t\t\t\t|--------------------------------------------------------------|");
								for(Entry<Integer, AccountDto> entry:acceptRequest.entrySet())
								{
									System.out.println("\t\t\t\t|--------------------------------------------------------------|");
									System.out.println("\t\t\t\t|"+entry.getKey()+"      \t\t  "+entry.getValue().getRequestMessage()+"  \t\t    "+entry.getValue().getDate()+" |");
								}
								System.out.println("\t\t\t\t|--------------------------------------------------------------|");				
								
								boolean displayDetail=true;
								while(displayDetail)
								{
									System.out.println("\n\n\t\t\t\tPress 1:  to View the Details of Request ID");
									System.out.println("\t\t\t\tPress 2: to go to previous request");
									
									System.out.print("\n\t\t\t\tEnter your choice: ");
									int displayChoice=sc.nextInt();
									switch(displayChoice)
									{
										case 1:
										{
											boolean flag=false;
											System.out.print("\n\t\t\t\tPlease enter the request Id: ");
											int requestId=sc.nextInt();
											for(Entry<Integer, AccountDto> entry:acceptRequest.entrySet())
											{
												if(entry.getKey()==requestId)
												{
													System.out.println("\n\t\t\t|Request Id  \t  User Name    \t   Account No.    \t  Balance    \t  Request Date|");
													System.out.println("\t\t\t|-------------------------------------------------------------------------------------|");
													System.out.println("\t\t\t|"+entry.getKey()+"      \t  "+entry.getValue().getUserName()+" "
															+ " \t    "+entry.getValue().getAccNo()+"  \t     "+entry.getValue().getBalance()
															+"  \t    "+entry.getValue().getDate()+"|");
													System.out.println("\t\t\t|-------------------------------------------------------------------------------------|");
													flag=true;
													break;
												}
											}
											if(!flag)
											{
												System.out.println("\n\t\t\t\tRquest Id not found, Please Enter the valid ID");
												break;
											}
											boolean acceptrequest=true;
											while(acceptrequest)
											{
												
												System.out.println("\n\n\t\t\t\tPress 1:  to accept the reqeust");
												System.out.println("\t\t\t\tPress 2:  to reject the reqeust");
												System.out.println("\t\t\t\tPress 3: to go to previous menu");
												
												System.out.print("\n\t\t\t\tEnter your choice: ");
												int requestChoice=sc.nextInt();
												switch(requestChoice)
												{
													case 1:
													{
														String acceptValue=adminServices.acceptRequest(requestId,1);
														System.out.println("\n\t\t\t\t"+acceptValue);
														acceptrequest=false;
														displayDetail=false;
														break;
													}
													case 2:
													{
														String rejectValue=adminServices.acceptRequest(requestId,2);
														System.out.println("\n\t\t\t\t"+rejectValue);
														acceptrequest=false;
														displayDetail=false;
														break;
													}
													case 3:
													{
														acceptrequest=false;
														break;
													}
													default:
													{
														System.out.println("\n\t\t\tPlease enter the valid choice!");
														break;
													}
												}
											}
											break;
										}
										case 2:
										{
											displayDetail=false;
											break;
										}
										default:
										{
											System.out.println("\n\t\t\t\tPlease enter the valid Choice");
											break;
										}
									}
								}
							}
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
					else
					{
						System.out.println("\n\t\t\tPlease enter the valid password");
					}
			}
					else
					{
						System.out.println("\n\t\t\tPlease enter the Valid user name");
					}
		}				//ending of admin menu


				//*****************************Customer Part************************************


				else if(Integer.parseInt(id)==2)					// opening of customer menu else part
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
																		System.out.print("\n\t\t\t\t\t\tEnter Customer Email Id: ");
																		String custEmailId=sc.next();
																		if(custEmailId.length()>0)
																		{
																			System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																			newUserName=sc.next();
																			System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																			newPassword=sc.next();
																			String newAccount=custServices.addCustomer(newUserName,newPassword,custName,custAge,
																		custGender,custAddress,custMobileNo,custAadharNo,custEmailId);
																			System.out.println("\n\n\t\t\t\t*****"+newAccount+"******\n");
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
																		System.out.print("\n\t\t\t\t\t\tplease set your UserName: ");
																		newUserName=sc.next();
																		System.out.print("\n\t\t\t\t\t\tplease set your Password: ");
																		newPassword=sc.next();
																		String newAccount=custServices.addCustomer(newUserName,newPassword,custName,custAge,
																	custGender,custAddress,custMobileNo,custAadharNo,"-");
																		System.out.println("\n\n\t\t\t\t*****"+newAccount+"******\n");
																		System.out.println("\n\t\t\t\t*****THANK YOU FOR CREATING AN ACCOUNT*****");
																		emailReq=false;
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
							}				//account form while loop ended
							//System.out.println("\n\t\t\t\t\t\tCreate account service is under progress");

							break;
						}
						case 2:
						{
							System.out.print("\n\n\t\t\t\tplease Enter your User Name  : ");
							String userName=sc.next();
							System.out.print("\t\t\t\tplease Enter your Password   : ");
							String password=sc.next();
									boolean custRequest1=true;
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
												
												System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : for statement");
												System.out.println("\t\t\t\t\t\t\t\tPress 2 : for Summary");
												System.out.println("\t\t\t\t\t\t\t\tPress 3 : for view Personal details");
												System.out.println("\t\t\t\t\t\t\t\tPress 4 : for going to previous menu");

												System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
												int custDetail=sc.nextInt();
												
												switch(custDetail)			//opening of customer details switch case
												{
							
												case 1:
												{
													//System.out.println("\t\t\t\t\t\t\t\tStatement service is under progress");
													String statement=custServices.viewStatement(userName);
													if(statement.equals("\n\t\t\t\t\t\t\t\tNo Transaction Yet."))
													{
														System.out.println(statement);
													}
													else
													{
														System.out.println("\t\t\t\t|-----------------------------------------------------------------------------------|");
														System.out.println("\t\t\t\t| current Balance\t    \tTRransfer Amount        \tDate of Transfer\t    |");
														System.out.println("\t\t\t\t|-----------------------------------------------------------------------------------|");
														System.out.println("\t\t\t\t|-----------------------------------------------------------------------------------|");
														System.out.println(statement);
													}	//System.out.println("\t\t\t\t|---------------------------------------------------------------------------------------------|");
													break;
												}
												case 2:
												{
													String summary=custServices.viewSummary(userName);
													System.out.println("\n\t\t\t\t\t\t\t\t|---------------------------------------------|");
													System.out.println("\t\t\t\t\t\t\t\t| Account No\t\t:\tBalance       |");
													System.out.println("\t\t\t\t\t\t\t\t|---------------------------------------------|");
													System.out.println("\t\t\t\t\t\t\t\t|---------------------------------------------|");
													System.out.println(summary);
													System.out.println("\t\t\t\t\t\t\t\t|---------------------------------------------|");
													//System.out.println("\t\t\t\t\t\t\t\tSummary service is under progress");
													break;
												}
												case 3:
												{
													String personalDetails=custServices.viewPersonalDetails(userName);
													System.out.print("\n\n\t\t\t\t\t|---------------------------------------------------|");
													System.out.print(personalDetails);
													System.out.println("\t\t\t\t\t|---------------------------------------------------|\n");
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
												System.out.println("\n\n\t\t\t\t\t\t\t\tPress 1 : Transfer the Money");
												//System.out.println("\t\t\t\t\t\t\t\tPress 2 : Transfer in different bank");
												System.out.println("\t\t\t\t\t\t\t\tPress 2 : for going to previous menu");

												System.out.print("\n\n\t\t\t\t\t\t\t\tEnter your choice : ");
												int custTransfer=sc.nextInt();
												
												switch(custTransfer)			//opening of customer transfer switch case
												{
												case 1:
												{
													
													System.out.print("\n\n\t\t\t\t\t\tEnter the Customer Account No. : ");
													long receiverAccNo=sc.nextLong();
													System.out.print("\t\t\t\t\t\tEnter the  Amount Balance      : ");
													float transferBalance=sc.nextFloat();
													String returnUpdate=custServices. transferAmt(userName,receiverAccNo,transferBalance);
													System.out.println("\n\t\t\t\t\t\t\t"+returnUpdate);
													break;
												}
												case 2:
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
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
													String updateuserName=sc.next();
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New password : ");
													String updatepassword=sc.next();
													
													String passwordMessage=custServices.updatepassword(updateuserName,updatepassword);
													System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+passwordMessage);
													
													break;
												}
												case 2:
												{
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
													String updateuserName=sc.next();
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Contact No. : ");
													long updateContactNo=sc.nextLong();
													
													String contactMessage=custServices.updateContactDetails(updateuserName,updateContactNo);
													System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+contactMessage);
													break;
												}
												case 3:
												{
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
													String updateuserName=sc.next();
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Email : ");
													String updateEmail=sc.next();
													
													String EmailMessage=custServices.updateEmail(updateuserName,updateEmail);
													System.out.println("\n\t\t\t\t\t\t\t\t\t\t"+EmailMessage);
													break;
												}
												case 4:
												{
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your User name  : ");
													String updateuserName=sc.next();
													System.out.print("\n\t\t\t\t\t\t\t\t\t\t Please Enter your New Address : ");
													String updateAddress=sc.next();
													
													String addressMessage=custServices.updateAddress(updateuserName,updateAddress);
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
																												int requestId=custServices.requestCreditCard
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
													int requestId=custServices.requestChequeBook(userName,accountNo);
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
													System.out.print("\n\t\t\t\t\t\tEnter the Request ID: ");
													int requestId=sc.nextInt();
													String status=custServices.checkRequestStatus(userName,requestId);
													System.out.println(status);
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
				else if(Integer.parseInt(id)==3)
				{
					System.out.println("\n\n\t\t*************************Thank you coming*********************\n\n\t\t");
					System.exit(0);
				}
				else
				{
					System.out.println("You have entered the wrong choice");
				}
			}
				else			//Is digit validation failed.
				{
					System.out.println("\n\t\tPlease enter the valid input");
				}

			}					//Ending of Main While Loop

		}			// Ending of Main function

	}		//Ending of Main public Class}		//Ending of Main public Class